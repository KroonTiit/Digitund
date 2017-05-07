package com.digitund.answers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class AnswerOptions {
	@Id @GeneratedValue
	private Long id;
	private Long question_id;
	private Boolean correct;
	private String tekst;
	
	public AnswerOptions (){}
	public AnswerOptions (Long id){
		this.question_id=question_id;
	}
	public AnswerOptions (Long id, Long question_id){
		this.id=id;
		this.question_id=question_id;
	}
	public AnswerOptions (Long question_id, Boolean correct, String tekst){
		this.question_id=question_id;
		this.correct=correct;
		this.tekst=tekst;
	}
	public AnswerOptions (Long id, Long question_id, Boolean correct, String tekst){
		this.id=id;
		this.question_id=question_id;
		this.correct=correct;
		this.tekst=tekst;
	}
	public long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	
}
