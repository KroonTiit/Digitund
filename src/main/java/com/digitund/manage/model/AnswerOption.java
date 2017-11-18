package com.digitund.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class AnswerOption {
	@Id @GeneratedValue
	private Long id;
	private Long questionId;
	private Boolean correct;
	private String text;
	
	public AnswerOption(){}
	
	public AnswerOption(Long id){
		this.id=id;
	}
	public AnswerOption(Long questionId, Boolean correct, String text){
		this.questionId=questionId;
		this.correct=correct;
		this.text=text;
	}
	public AnswerOption(Long id, Long questionId, Boolean correct, String tekst){
		this.id=id;
		this.questionId=questionId;
		this.correct=correct;
		this.text=tekst;
	}
	public long getQuestion_id() {
		return questionId;
	}
	public void setQuestion_id(Long questionId) {
		this.questionId = questionId;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	public String getTekst() {
		return text;
	}
	public void setTekst(String tekst) {
		this.text = tekst;
	}
	
	
}
