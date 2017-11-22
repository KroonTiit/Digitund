package com.digitund.perform.rest.model;

public class OrderedAnswerData {

  private Long id;
  private Long questionId;
  private String text;
  private Long orderNr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(Long orderNr) {
		this.orderNr = orderNr;
	}
  
  
}
