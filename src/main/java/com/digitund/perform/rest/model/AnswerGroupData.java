package com.digitund.perform.rest.model;

public class AnswerGroupData {

  public Long id;
  public String text;
  public AnswerGroupAnswerData answerGroupAnswer;
  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public AnswerGroupAnswerData getAnswerGroupAnswer() {
		return answerGroupAnswer;
	}
	public void setAnswerGroupAnswer(AnswerGroupAnswerData answerGroupAnswer) {
		this.answerGroupAnswer = answerGroupAnswer;
	}
}
