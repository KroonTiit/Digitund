package com.digitund.lesson;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Lesson {
	@Id @GeneratedValue
	private long id;
	private String userId;
	private Timestamp startTime ;
	private Timestamp endTime;
	private Timestamp created;
	private String name;
	private String description;
	
	public Lesson(){}
	public Lesson(String creatorId){
		this.userId=creatorId;
	}
	public Lesson(long id, String creatorId){
		this.id=id;
		this.userId=creatorId;
	}
	public Lesson(Timestamp startDate, Timestamp endDate, Timestamp created,String userId){
		this.startTime=startDate;
		this.endTime=endDate;
		this.created=created;
		this.userId=userId;
//		this.lessonPermalink=lessonPermalink;
	}
	public Lesson(Timestamp startDate, Timestamp created, String userId, String name) {
		this.startTime=startDate;
		this.created=created;
		this.userId=userId;
//		this.lessonPermalink=lessonPermaLink;
		this.name=name;
	}
	public Lesson(Timestamp startDate, Timestamp created, String userId, String name, String description) {
		this.startTime=startDate;
		this.created=created;
		this.userId=userId;
//		this.lessonPermalink=lessonPermaLink;
		this.name=name;
		this.description=description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreatorId() {
		return userId;
	}
	public void setCreatorId(String userId) {
		this.userId = userId;
	}
	public Timestamp getStart_date() {
		return startTime;
	}
	public void setStart_date(Timestamp startDate) {
		this.startTime = startDate;
	}
	public Timestamp getEnd_date() {
		return endTime;
	}
	public void setEnd_date(Timestamp endDate) {
		this.endTime = endDate;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
