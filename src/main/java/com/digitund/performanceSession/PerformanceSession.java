package com.digitund.performanceSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class PerformanceSession {
	@Id @GeneratedValue
	private Long id;
	private long performanceId;
	private long questionsId;
	private long answerOptionId;
	
	public PerformanceSession(){}
	public PerformanceSession(long performanceId, long questionsId, long answerOptionId){
		this.performanceId=performanceId;
		this.questionsId=questionsId;
		this.answerOptionId=answerOptionId;
	}
	
	public long getPerformance_id() {
		return performanceId;
	}
	public void setPerformance_id(long performanceId) {
		this.performanceId = performanceId;
	}
	public long getQuestions_id() {
		return questionsId;
	}
	public void setQuestions_id(long questionsId) {
		this.questionsId = questionsId;
	}
	public long getAnswer_options_id() {
		return answerOptionId;
	}
	public void setAnswer_options_id(long answerOptionId) {
		this.answerOptionId = answerOptionId;
	}
}
