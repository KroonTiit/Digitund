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
	private Timestamp start_date;
	
	public Performance(){}
	public Performance(long performer_id, long lesson_id){
		this.performer_id=performer_id;
		this.lesson_id=lesson_id;
	}
	public Performance(long performer_id, long lesson_id, Timestamp start_date){
		this.performer_id=performer_id;
		this.lesson_id=lesson_id;
		this.start_date=start_date;
	}
	public long getPerformer_id() {
		return performer_id;
	}
	public void setPerformer_id(long performer_id) {
		this.performer_id = performer_id;
	}
	public long getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(long lesson_id) {
		this.lesson_id = lesson_id;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	
}
