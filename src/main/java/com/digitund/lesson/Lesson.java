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
	private Timestamp startDate ;
	private Timestamp endDate;
	private Timestamp created;
//	private String lessonPermalink;
	private String name;
	
	public Lesson(){}
	public Lesson(Long creatorId){
		this.creatorId=creatorId;
	}
	public Lesson(long id, Long creatorId){
		this.id=id;
		this.creatorId=creatorId;
	}
	public Lesson(Timestamp startDate, Timestamp endDate, Timestamp created,long creatorId){
		this.startDate=startDate;
		this.endDate=endDate;
		this.created=created;
		this.creatorId=creatorId;
//		this.lessonPermalink=lessonPermalink;
	}
	public Lesson(Timestamp startDate, Timestamp created, long creatorId, String name) {
		this.startDate=startDate;
		this.created=created;
		this.creatorId=creatorId;
//		this.lessonPermalink=lessonPermaLink;
		this.name=name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}
	public Timestamp getStart_date() {
		return startDate;
	}
	public void setStart_date(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEnd_date() {
		return endDate;
	}
	public void setEnd_date(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
//	public String getLessonPermalink() {
//		return lessonPermalink;
//	}
//	public void setLessonPermalink(String lessonPermalink) {
//		this.lessonPermalink = lessonPermalink;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
