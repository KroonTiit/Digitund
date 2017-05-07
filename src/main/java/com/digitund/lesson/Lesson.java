package com.digitund.lesson;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Lesson {
	@Id @GeneratedValue
	private long id;
	private long creatorId;
	private Timestamp start_date ;
	private Timestamp end_date;
	private Timestamp created;
	private String lessonPermalink;
	private String name;
	
	public Lesson(){}
	public Lesson(Long creatorId){
		this.creatorId=creatorId;
	}
	public Lesson(long id, Long creatorId){
		this.id=id;
		this.creatorId=creatorId;
	}
	public Lesson(Timestamp start_date, Timestamp end_date, Timestamp created,long creatorId, String lessonPermalink){
		this.start_date=start_date;
		this.end_date=end_date;
		this.created=created;
		this.creatorId=creatorId;
		this.lessonPermalink=lessonPermalink;
	}
	public Lesson(Timestamp start_date, Timestamp created, long creatorId, String lessonPermaLink, String name) {
		this.start_date=start_date;
		this.created=created;
		this.creatorId=creatorId;
		this.lessonPermalink=lessonPermaLink;
		this.name=name;
	}
	public long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getLessonPermalink() {
		return lessonPermalink;
	}
	public void setLessonPermalink(String lessonPermalink) {
		this.lessonPermalink = lessonPermalink;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
