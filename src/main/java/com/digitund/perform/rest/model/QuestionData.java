package com.digitund.perform.rest.model;

import com.digitund.manage.model.Question;
import java.util.List;

public class QuestionData {

  public Long id;
  public String text;
  public String type;
  public List<AnswerOptionData> answerOptions;
  public List<OrderedAnswerData> orderedAnswers;
  public List<AnswerGroupData> answerGroups;
  public List<AnswerGroupAnswerData> answerGroupAnswers;

  public static QuestionData fromModel(Question question) {
    QuestionData data = new QuestionData();
    data.id = question.getId();
    data.text = question.getText();
    data.type = question.getType().name();
    return data;
  }

}
