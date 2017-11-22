package com.digitund.perform.service;

import com.digitund.manage.data.AnswerGroupAnswerRepo;
import com.digitund.manage.data.AnswerGroupRepo;
import com.digitund.manage.data.AnswerOptionRepo;
import com.digitund.manage.data.CompMaterialRepo;
import com.digitund.manage.data.MaterialRepo;
import com.digitund.manage.data.OrderedAnswerRepo;
import com.digitund.manage.data.QuestionRepo;
import com.digitund.manage.model.AnswerGroup;
import com.digitund.manage.model.AnswerOption;
import com.digitund.manage.model.CompMaterial;
import com.digitund.manage.model.OrderedAnswer;
import com.digitund.manage.model.Question;
import com.digitund.perform.rest.model.AnswerGroupAnswerData;
import com.digitund.perform.rest.model.AnswerGroupData;
import com.digitund.perform.rest.model.AnswerOptionData;
import com.digitund.perform.rest.model.OrderedAnswerData;
import com.digitund.perform.rest.model.QuestionData;
import com.digitund.perform.rest.model.StartPerformanceResponse;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PerformanceService {
	private CompMaterialRepo compMaterialRepo;
	private MaterialRepo materialRepo;
	private QuestionRepo questionRepo;
	private AnswerGroupRepo answerGroupRepo;
	private AnswerGroupAnswerRepo answerGroupAnswerRepo;
	private OrderedAnswerRepo orderedAnswerRepo;
	private AnswerOptionRepo answerOptionRepo;
	
  public StartPerformanceResponse startPerformanceResponse(Long lessonId, String userId) {
    // TODO query and assemble data
    return new StartPerformanceResponse();
  }

  public StartPerformanceResponse startLesson(String lessonId) {
	  StartPerformanceResponse PerformanceResponse = new StartPerformanceResponse();
	  CompMaterial compMaterial = compMaterialRepo.findOneByLessonId(Long.decode(lessonId), 1L);
	  PerformanceResponse.setOrderNr(compMaterial.getOrderNr());
	  PerformanceResponse.setMaterials(materialRepo.findByCompId(compMaterial.getId()));
	  List<Question> queryResult = questionRepo.findByOrderNrAndCompId(compMaterial.getId(), compMaterial.getOrderNr());
	  List<QuestionData> questions = null;
	  for(Question question : queryResult){
		  QuestionData questionData = new QuestionData();
		  questionData.setId(question.getId());
		  questionData.setText(question.getText());
		  questionData.setCompMaterialId(question.getCompMaterialId());
		  
		  AnswerGroupData answerGroupData = null;
		  OrderedAnswerData orderedAnswersData = null;
		  List<AnswerOptionData> answerOptionsData = null;
		switch(question.getType()){
		  case "GROUP": 
			  AnswerGroup answerGroup = answerGroupRepo.findByQuestionId(question.getId());
			  answerGroupData.setId(answerGroup.getId());
			  answerGroupData.setText(answerGroup.getText());
			  answerGroupData.setAnswerGroupAnswer((AnswerGroupAnswerData) answerGroupAnswerRepo.findByAnswerGroupId(answerGroup.getId()));
			  questionData.setAnswerGroups(answerGroupData);
		  case "ORDER": 
			  OrderedAnswer orderedAnswer = orderedAnswerRepo.findByQuestionId(question.getId());
			  orderedAnswersData.setId(orderedAnswer.getId());
			  orderedAnswersData.setOrderNr(orderedAnswer.getOrderNr());
			  orderedAnswersData.setQuestionId(orderedAnswer.getQuestionId());
			  orderedAnswersData.setText(orderedAnswer.getText());
			  questionData.setOrderedAnswers(orderedAnswersData);
		  case "CHOOSE": 
			  List<AnswerOption> answerOptions = answerOptionRepo.findByQuestionId(question.getId());
			  for(AnswerOption answerOption : answerOptions){
				  AnswerOptionData aod = new AnswerOptionData();
				  aod.setId(answerOption.getId());
				  aod.setText(answerOption.getText());
				  answerOptionsData.add(aod);
			  }
			  questionData.setAnswerOptions(answerOptionsData);
		  }
		  questions.add(questionData);
	  }
	  PerformanceResponse.setQuestions(questions);
	  return PerformanceResponse;
  }
  public void nextMaterial(String lessonId) {
	  StartPerformanceResponse PerformanceResponse = new StartPerformanceResponse();
	  
  }

}
