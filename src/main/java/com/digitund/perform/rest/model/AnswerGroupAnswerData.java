package com.digitund.perform.rest.model;

import com.digitund.manage.model.AnswerGroupAnswer;

public class AnswerGroupAnswerData {

  public Long id;
  public String text;

	public static AnswerGroupAnswerData fromModel(AnswerGroupAnswer answer) {
		AnswerGroupAnswerData data = new AnswerGroupAnswerData();
		data.id = answer.getId();
		data.text = answer.getText();
		return data;
	}
  
}
