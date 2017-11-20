package com.digitund.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class AnswerGroupAnswer {
	@Id @GeneratedValue
	private Long id;
	private long answerGroupId;
	private String text;
	
	public AnswerGroupAnswer(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getAnswerGroupId() {
		return answerGroupId;
	}
	public void setAnswerGroupId(long answerGroupId) {
		this.answerGroupId = answerGroupId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
