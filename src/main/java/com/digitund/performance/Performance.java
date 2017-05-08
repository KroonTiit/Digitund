package com.digitund.performance;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Performance {
	@Id @GeneratedValue
	private Long id;
	private long performer_id;
	private long lesson_id;
	private Timestamp startDate;
	
	public Performance(){}
	public Performance(long performerId, long lessonId){
		this.performer_id=performerId;
		this.lesson_id=lessonId;
	}
	public Performance(long performerId, long lessonId, Timestamp startDate){
		this.performer_id=performerId;
		this.lesson_id=lessonId;
		this.startDate=startDate;
	}
	public long getPerformer_id() {
		return performer_id;
	}
	public void setPerformer_id(long performerId) {
		this.performer_id = performerId;
	}
	public long getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(long lessonId) {
		this.lesson_id = lessonId;
	}
	public Timestamp getStart_date() {
		return startDate;
	}
	public void setStart_date(Timestamp startDate) {
		this.startDate = startDate;
	}
	
}
