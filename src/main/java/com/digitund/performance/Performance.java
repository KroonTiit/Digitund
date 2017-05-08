package com.digitund.performance;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Performance {
	@Id @GeneratedValue
	private Long id;
	private long performerId;
	private long lessonId;
	private Timestamp startSate;
	
	public Performance(){}
	public Performance(long performerId, long lessonId){
		this.performerId=performerId;
		this.lessonId=lessonId;
	}
	public Performance(long performerId, long lessonId, Timestamp startSate){
		this.performerId=performerId;
		this.lessonId=lessonId;
		this.startSate=startSate;
	}
	public long getPerformer_id() {
		return performerId;
	}
	public void setPerformer_id(long performerId) {
		this.performerId = performerId;
	}
	public long getLesson_id() {
		return lessonId;
	}
	public void setLesson_id(long lessonId) {
		this.lessonId = lessonId;
	}
	public Timestamp getStart_date() {
		return startSate;
	}
	public void setStart_date(Timestamp startSate) {
		this.startSate = startSate;
	}
	
}
