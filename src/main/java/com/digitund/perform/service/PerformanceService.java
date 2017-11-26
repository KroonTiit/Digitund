package com.digitund.perform.service;

import com.digitund.manage.data.AnswerGroupAnswerRepo;
import com.digitund.manage.data.AnswerGroupRepo;
import com.digitund.manage.data.AnswerOptionRepo;
import com.digitund.manage.data.CompMaterialRepo;
import com.digitund.manage.data.MaterialRepo;
import com.digitund.manage.data.OrderedAnswerRepo;
import com.digitund.manage.data.QuestionRepo;
import com.digitund.manage.model.AnswerGroupAnswer;
import com.digitund.manage.model.AnswerOption;
import com.digitund.manage.model.CompMaterial;
import com.digitund.manage.model.OrderedAnswer;
import com.digitund.manage.model.Question;
import com.digitund.perform.data.FailedQuestionRepo;
import com.digitund.perform.data.InProgressQuestionRepo;
import com.digitund.perform.data.PerformanceRepo;
import com.digitund.perform.model.FailedQuestion;
import com.digitund.perform.model.InProgressQuestion;
import com.digitund.perform.model.Performance;
import com.digitund.perform.rest.model.AnswerRequest;
import com.digitund.perform.rest.model.AnswerGroupAnswerData;
import com.digitund.perform.rest.model.AnswerGroupData;
import com.digitund.perform.rest.model.AnswerOptionData;
import com.digitund.perform.rest.model.AnswerQuestionResponse;
import com.digitund.perform.rest.model.AnswerRequestAnswer;
import com.digitund.perform.rest.model.CompMaterialData;
import com.digitund.perform.rest.model.MaterialData;
import com.digitund.perform.rest.model.OrderedAnswerData;
import com.digitund.perform.rest.model.PerformanceData;
import com.digitund.perform.rest.model.QuestionData;
import com.digitund.perform.rest.model.StartPerformanceResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class PerformanceService {

  private final CompMaterialRepo compMaterialRepo;
  private final MaterialRepo materialRepo;
  private final QuestionRepo questionRepo;
  private final AnswerGroupRepo answerGroupRepo;
  private final AnswerGroupAnswerRepo answerGroupAnswerRepo;
  private final OrderedAnswerRepo orderedAnswerRepo;
  private final AnswerOptionRepo answerOptionRepo;
  private final PerformanceRepo performanceRepo;
  private final FailedQuestionRepo failedQuestionRepo;
  private final InProgressQuestionRepo inProgressQuestionRepo;

  private final Random random = new Random();

  @Autowired
  public PerformanceService(
      CompMaterialRepo compMaterialRepo,
      MaterialRepo materialRepo,
      QuestionRepo questionRepo,
      AnswerGroupRepo answerGroupRepo,
      AnswerGroupAnswerRepo answerGroupAnswerRepo,
      OrderedAnswerRepo orderedAnswerRepo,
      AnswerOptionRepo answerOptionRepo,
      PerformanceRepo performanceRepo,
      FailedQuestionRepo failedQuestionRepo,
      InProgressQuestionRepo inProgressQuestionRepo) {
    this.compMaterialRepo = compMaterialRepo;
    this.materialRepo = materialRepo;
    this.questionRepo = questionRepo;
    this.answerGroupRepo = answerGroupRepo;
    this.answerGroupAnswerRepo = answerGroupAnswerRepo;
    this.orderedAnswerRepo = orderedAnswerRepo;
    this.answerOptionRepo = answerOptionRepo;
    this.performanceRepo = performanceRepo;
    this.failedQuestionRepo = failedQuestionRepo;
    this.inProgressQuestionRepo = inProgressQuestionRepo;
  }

  public StartPerformanceResponse startPerformance(Long lessonId, String userId) {
    StartPerformanceResponse response = new StartPerformanceResponse();
    PerformanceData performance = getPerformanceData(lessonId, userId);
    response.performance = performance;
    response.materials = getMaterials(performance.activeCompMaterialId);
    response.questions = getQuestions(performance);
    return response;
  }

  private List<MaterialData> getMaterials(Long compMaterialId) {
    return materialRepo.findByCompId(compMaterialId).stream()
        .map(MaterialData::fromModel)
        .collect(Collectors.toList());
  }

  private List<QuestionData> getQuestions(PerformanceData performance) {
    List<InProgressQuestion> inProgressQuestions = inProgressQuestionRepo
        .findByPerformanceId(performance.performanceId);
    Set<Long> questionIds = new HashSet<>();
    if (CollectionUtils.isEmpty(inProgressQuestions)) {
      Optional<CompMaterialData> firstFailedCompMaterial = performance.compMaterials.stream()
          .filter(cm -> cm.failed)
          .findFirst(); // Assuming compMaterials are sorted by orderNr
      if (firstFailedCompMaterial.isPresent()) {
        // Take only 1 question from the first failed comp material if present.
        questionIds.add(getRandomQuestionIdFromCompMaterial(firstFailedCompMaterial.get().id));
      } else {
        // Take 1 question from the active comp material and 2 from previous comp materials.
        questionIds.add(getRandomQuestionIdFromCompMaterial(performance.activeCompMaterialId));
        Set<Long> previousCompMaterialIds = new HashSet<>(2);
        while (previousCompMaterialIds.size() < 2) {
          // TODO Should consider if we really want to get questions from distinct complex materials
          int randomIndex = random.nextInt(performance.compMaterials.size() - 1);
          previousCompMaterialIds.add(performance.compMaterials.get(randomIndex).id);
        }
        for (Long prevCompMaterialId : previousCompMaterialIds) {
          questionIds.add(getRandomQuestionIdFromCompMaterial(prevCompMaterialId));
        }
      }
      inProgressQuestionRepo.save(questionIds.stream()
          .map(questionId -> new InProgressQuestion(questionId, performance.performanceId))
          .collect(Collectors.toList())
      );
    } else {
      questionIds.addAll(inProgressQuestions.stream()
          .map(InProgressQuestion::getQuestionId)
          .collect(Collectors.toSet()));
    }
    return questionRepo.findAll(questionIds).stream()
        .map(q -> {
          QuestionData data = QuestionData.fromModel(q);
          addQuestionTypeSpecificData(q, data);
          return data;
        })
        .collect(Collectors.toList());
  }

  private Long getRandomQuestionIdFromCompMaterial(Long compMaterialId) {
    List<Question> questions = questionRepo.findByCompMaterial(compMaterialId);
    return questions.get(random.nextInt(questions.size())).getId();
  }

  private PerformanceData getPerformanceData(Long lessonId, String userId) {
    Optional<Performance> activePerformance = performanceRepo
        .findInProgressByPerformerAndLesson(userId, lessonId);
    PerformanceData data = new PerformanceData();
    List<CompMaterial> compMaterials = compMaterialRepo.findByLessonId(lessonId);
    data.compMaterials = compMaterials.stream()
        .sorted(Comparator.comparingInt(CompMaterial::getOrderNr))
        .map(CompMaterialData::fromModel)
        .collect(Collectors.toList());
    Long performanceId;
    if (activePerformance.isPresent()) {
      performanceId = activePerformance.get().getId();
      List<FailedQuestion> failedQuestions =
          failedQuestionRepo.findUncorrectedByPerformanceId(performanceId);
      failedQuestions.stream()
          .map(FailedQuestion::getOrderNr)
          .distinct()
          .forEach((failedOrderNr -> {
            data.compMaterials.stream()
                .filter(cm -> cm.orderNr == failedOrderNr)
                .findAny()
                .ifPresent(cm -> cm.failed = true);
          }));
      data.performanceId = activePerformance.get().getId();
      data.activeOrderNr = activePerformance.get().getActiveOrderNr();
    } else {
      data.performanceId = createPerformance(lessonId, userId).getId();
      data.activeOrderNr = 1;
    }

    int currentOrderNr = data.compMaterials.stream()
        .filter(cm -> cm.failed)
        .map(cm -> cm.orderNr)
        .min(Integer::compareTo)
        .orElse(data.activeOrderNr);

    data.activeCompMaterialId = compMaterials.stream()
        .filter(cm -> cm.getOrderNr() == currentOrderNr)
        .map(CompMaterial::getId)
        .findFirst().orElseThrow(IllegalStateException::new);

    return data;
  }

  private Performance createPerformance(Long lessonId, String userId) {
    Performance performance = new Performance();
    performance.setPerformerId(userId);
    performance.setLessonId(lessonId);
    performance.setStartTime(LocalDateTime.now());
    return performanceRepo.save(performance);
  }

  private void addQuestionTypeSpecificData(Question q, QuestionData data) {
    switch (q.getType()) {
      case GROUP:
        data.answerGroups = answerGroupRepo.findByQuestionId(q.getId()).stream()
            .map(AnswerGroupData::fromModel)
            .collect(Collectors.toList());
        Set<Long> groupIds = data.answerGroups.stream()
            .map(g -> g.id)
            .collect(Collectors.toSet());
        data.answerGroupAnswers = answerGroupAnswerRepo.findByGroupIds(groupIds).stream()
            .map(AnswerGroupAnswerData::fromModel)
            .collect(Collectors.toList());
        break;
      case ORDER:
        data.orderedAnswers = orderedAnswerRepo.findByQuestionId(q.getId()).stream()
            .map(OrderedAnswerData::fromModel)
            .collect(Collectors.toList());
        break;
      case CHOOSE:
        data.answerOptions = answerOptionRepo.findByQuestionId(q.getId()).stream()
            .map(AnswerOptionData::fromModel)
            .collect(Collectors.toList());
        break;
    }
  }

  @Transactional
  public AnswerQuestionResponse answerQuestion(AnswerRequest answerRequest, Long lessonId, String userId) {
    PerformanceData performance = getPerformanceData(lessonId, userId);
    inProgressQuestionRepo.deleteByPerformanceId(performance.performanceId);
    Optional<CompMaterialData> firstFailedCompMaterial = performance.compMaterials.stream()
        .filter(cm -> cm.failed)
        .findFirst();

    List<FailedQuestion> failedQuestions = validateAnswerRequest(answerRequest);

    if (firstFailedCompMaterial.isPresent() && failedQuestions.isEmpty()) {
      failedQuestionRepo.setCorrectedByPerformanceAndCompMaterial(
          performance.performanceId,
          firstFailedCompMaterial.get().id
      );
      firstFailedCompMaterial.get().failed = false;
    } else {
      for (FailedQuestion failedQuestion : failedQuestions) {
        performance.compMaterials.stream()
            .filter(cm -> cm.id.equals(failedQuestion.getCompMaterialId()))
            .findFirst()
            .ifPresent(cm -> cm.failed = true);
        CompMaterialData latestCompMaterial =
            performance.compMaterials.get(performance.compMaterials.size() - 1);
        if (!latestCompMaterial.failed) {
          // TODO Update activeOrderNr and activeCompMaterialId in performance.
          // Performance completion logic should be here aswell.
        }
      }
    }

    AnswerQuestionResponse response = new AnswerQuestionResponse();
    response.performance = performance;
    response.materials = getMaterials(performance.activeCompMaterialId);
    response.questions = getQuestions(performance);
    return response;
  }

  private List<FailedQuestion> validateAnswerRequest(AnswerRequest answerRequest) {
    List<Long> questionIds = answerRequest.answers.stream()
        .map((AnswerRequestAnswer a) -> a.questionId)
        .collect(Collectors.toList());
    List<Question> questions = questionRepo.findAll(questionIds);
    List<FailedQuestion> result = new ArrayList<>();
    for (AnswerRequestAnswer answer : answerRequest.answers) {
      Question question = questions.stream()
          .filter(q -> q.getId().equals(answer.questionId))
          .findFirst()
          .orElseThrow(() -> new IllegalStateException("Question not found: " + answer.questionId));
      validateAnswer(question, answer, answerRequest.performanceId)
          .ifPresent(result::add);
    }
    return result;
  }

  private Optional<FailedQuestion> validateAnswer(
      Question question,
      AnswerRequestAnswer answer,
      Long performanceId
  ) {
    switch (question.getType()) {
      case CHOOSE:
        if (!validateAnswerOptions(question.getId(), answer.answerOptions)) {
          // TODO need to get orderNr from compMaterial?
          FailedQuestion failed = saveFailedQuestion(question, answer, performanceId, 1);
          return Optional.of(failed);
        }
        break;
      case ORDER:
        if (!validateOrderedAnswers(question.getId(), answer.orderedAnswers)) {
          FailedQuestion failed = saveFailedQuestion(question, answer, performanceId, 1);
          return Optional.of(failed);
        }
        break;
      case GROUP:
        if (!validateAnswerGroups(question.getId(), answer.answerGroups)) {
          FailedQuestion failed = saveFailedQuestion(question, answer, performanceId, 1);
          return Optional.of(failed);
        }
        break;
    }
    return Optional.empty();
  }

  private boolean validateAnswerOptions(Long questionId, List<Long> selectedAnswerOptionIds) {
    List<AnswerOption> answerOptions = answerOptionRepo.findByQuestionId(questionId);
    return answerOptions.stream()
        .filter(AnswerOption::isCorrect)
        .allMatch(opt -> selectedAnswerOptionIds.contains(opt.getId()));
  }

  private boolean validateOrderedAnswers(Long questionId, List<Long> orderedAnswerIds) {
    List<OrderedAnswer> orderedAnswers = orderedAnswerRepo.findByQuestionId(questionId);
    for (int i = 0; i < orderedAnswerIds.size(); i++) {
      Long answerId = orderedAnswerIds.get(i);
      OrderedAnswer orderedAnswer = orderedAnswers.stream()
          .filter(oa -> oa.getId() == answerId)
          .findFirst().orElseThrow(IllegalStateException::new);
      if (orderedAnswer.getOrderNr() != i) {
        return false;
      }
    }
    return true;
  }

  private boolean validateAnswerGroups(Long questionId, Map<Long, List<Long>> groupedAnswers) {
    List<AnswerGroupAnswer> groupAnswers = answerGroupAnswerRepo
        .findByQuestionId(questionId);
    for (Entry<Long, List<Long>> group : groupedAnswers.entrySet()) {
      boolean groupMatches = groupAnswers.stream()
          .filter(ga -> group.getValue().contains(ga.getId()))
          .allMatch(ga -> ga.getAnswerGroup().getId() == group.getKey());
      if (!groupMatches) {
        return false;
      }
    }
    return true;
  }

  private FailedQuestion saveFailedQuestion(
      Question question,
      AnswerRequestAnswer answer,
      Long performanceId,
      int orderNr
  ) {
    FailedQuestion failedQuestion = new FailedQuestion();
    failedQuestion.setCompMaterialId(question.getCompMaterialId());
    failedQuestion.setCorrected(false);
    failedQuestion.setFailTime(LocalDateTime.now());
    failedQuestion.setPerformanceId(performanceId);
    failedQuestion.setQuestionType(question.getType());
    failedQuestion.setAnswerJson(answer);
    failedQuestion.setOrderNr(orderNr);
    return failedQuestionRepo.save(failedQuestion);
  }
}
