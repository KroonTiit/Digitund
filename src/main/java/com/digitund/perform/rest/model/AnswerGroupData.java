package com.digitund.perform.rest.model;

import com.digitund.manage.model.AnswerGroup;

public class AnswerGroupData {

  public Long id;
  public String text;

  public static AnswerGroupData fromModel(AnswerGroup answerGroup) {
    AnswerGroupData data = new AnswerGroupData();
    data.id = answerGroup.getId();
    data.text = answerGroup.getText();
    return data;
  }

}
