package com.digitund.perform.rest.model;

import com.digitund.manage.model.AnswerOption;

public class AnswerOptionData {

  public Long id;
  public String text;

	public static AnswerOptionData fromModel(AnswerOption answerOption) {
		AnswerOptionData data = new AnswerOptionData();
		data.id = answerOption.getId();
		data.text = answerOption.getText();
		return data;
	}
  
}
