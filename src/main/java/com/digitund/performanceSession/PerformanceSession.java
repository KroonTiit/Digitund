package com.digitund.performanceSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class PerformanceSession {
	@Id @GeneratedValue
	private Long id;
	private Long performance_id;//peab selline olema et andmebaas tunneks objeti ära
	private Long questions_id;//peab selline olema et andmebaas tunneks objeti ära
	private Long answer_options_id;
	
	public PerformanceSession(){}
	public PerformanceSession(Long performanceId, Long questionsId, Long answerOptionId){
		this.performance_id=performanceId;
		this.questions_id=questionsId;
		this.answer_options_id=answerOptionId;
	}
	
	public long getPerformance_id() {
		return performance_id;
	}
	public void setPerformance_id(long performanceId) {
		this.performance_id = performanceId;
	}
	public Long getQuestions_id() {
		return questions_id;
	}
	public void setQuestions_id(long questionsId) {
		this.questions_id = questionsId;
	}
	public Long getAnswer_options_id() {
		return answer_options_id;
	}
	public void setAnswer_options_id(long answerOptionId) {
		this.answer_options_id = answerOptionId;
	}
}
