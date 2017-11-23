package com.digitund.perform.service;

import com.digitund.manage.data.AnswerGroupAnswerRepo;
import com.digitund.manage.data.AnswerGroupRepo;
import com.digitund.manage.data.AnswerOptionRepo;
import com.digitund.manage.data.CompMaterialRepo;
import com.digitund.manage.data.MaterialRepo;
import com.digitund.manage.data.OrderedAnswerRepo;
import com.digitund.manage.data.QuestionRepo;
import com.digitund.manage.model.CompMaterial;
import com.digitund.manage.model.Question;
import com.digitund.perform.data.PerformanceRepo;
import com.digitund.perform.model.Performance;
import com.digitund.perform.rest.model.AnswerData;
import com.digitund.perform.rest.model.AnswerGroupAnswerData;
import com.digitund.perform.rest.model.AnswerGroupData;
import com.digitund.perform.rest.model.AnswerOptionData;
import com.digitund.perform.rest.model.AnswerQuestionResponse;
import com.digitund.perform.rest.model.MaterialData;
import com.digitund.perform.rest.model.OrderedAnswerData;
import com.digitund.perform.rest.model.QuestionData;
import com.digitund.perform.rest.model.StartPerformanceResponse;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

  @Autowired
  private CompMaterialRepo compMaterialRepo;
  @Autowired
  private MaterialRepo materialRepo;
  @Autowired
  private QuestionRepo questionRepo;
  @Autowired
  private AnswerGroupRepo answerGroupRepo;
  @Autowired
  private AnswerGroupAnswerRepo answerGroupAnswerRepo;
  @Autowired
  private OrderedAnswerRepo orderedAnswerRepo;
  @Autowired
  private AnswerOptionRepo answerOptionRepo;
  @Autowired
  private PerformanceRepo performanceRepo;

  public StartPerformanceResponse startPerformance(Long lessonId, String userId) {
    /*
    Actually need to check failed_question table for any uncorrected failures and return
    the complex material of the one with the lowest order_nr.
     */
    List<CompMaterial> compMaterials = compMaterialRepo.findByLessonId(lessonId);
    CompMaterial firstCompMaterial = compMaterials.stream()
        .min(Comparator.comparingInt(CompMaterial::getOrderNr))
        .orElse(null);
    if (firstCompMaterial == null) {
      throw new IllegalStateException("Lesson should have complex materials present!");
    }
    StartPerformanceResponse response = new StartPerformanceResponse();
    response.lessonLength = compMaterials.size();
    response.compMaterialName = firstCompMaterial.getName();

    response.materials =  materialRepo.findByCompId(firstCompMaterial.getId()).stream()
        .map(MaterialData::fromModel)
        .collect(Collectors.toList());

    List<Question> questions = questionRepo.findByCompMaterial(firstCompMaterial.getId());
    response.questions = questions.stream()
        .map(q -> {
          QuestionData data = QuestionData.fromModel(q);
          // TODO it's actually not great to do DB queries in a loop like this
          addQuestionTypeSpecificData(q, data);
          return data;
        })
        .collect(Collectors.toList());
    createPerformance(lessonId, userId);
    return response;
  }

  private void createPerformance(Long lessonId, String userId) {
    Performance performance = new Performance();
    performance.setPerformerId(userId);
    performance.setLessonId(lessonId);
    performance.setStartDate(LocalDateTime.now());
    performanceRepo.save(performance);
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

  public void nextMaterial(String lessonId) {
    StartPerformanceResponse PerformanceResponse = new StartPerformanceResponse();

  }

  public AnswerQuestionResponse answerQuestion(AnswerData answer, String lessonId, String userId) {
    /*
    1. Check correctness of all question answers.
       - answering failed question successfully: set corrected flag of all failed_question for the
         given comp_material_id and user_id
       - all correct: return next complex material data and set performance.active_order_nr accordingly
       - answers incorrect: create failed_question for each incorrect answer and return
         the complex material data of the one with lowest order_nr
     */
    return null;
  }
}
