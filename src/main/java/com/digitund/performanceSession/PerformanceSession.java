package com.digitund.performanceSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class PerformanceSession {
	@Id @GeneratedValue
	private Long id;
	private long performance_id;
	private long questions_id;
	private long answer_options_id;
	
	public PerformanceSession(){}
	public PerformanceSession(long performance_id, long questions_id, long answer_options_id){
		this.performance_id=performance_id;
		this.questions_id=questions_id;
		this.answer_options_id=answer_options_id;
	}
	
	public long getPerformance_id() {
		return performance_id;
	}
	public void setPerformance_id(long performance_id) {
		this.performance_id = performance_id;
	}
	public long getQuestions_id() {
		return questions_id;
	}
	public void setQuestions_id(long questions_id) {
		this.questions_id = questions_id;
	}
	public long getAnswer_options_id() {
		return answer_options_id;
	}
	public void setAnswer_options_id(long answer_options_id) {
		this.answer_options_id = answer_options_id;
	}
}
