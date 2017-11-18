package com.digitund.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserGroupUser {
	@Id @GeneratedValue
	private Long id;
	private Long lessonId;
	private Long groupUserId;
	private String groupUserEmail;
	
	public UserGroupUser() {}
	
	public UserGroupUser(Long lessonId, Long groupUserId, String groupUserEmail) {
		this.lessonId=lessonId;
		this.groupUserId=groupUserId;
		this.groupUserEmail=groupUserEmail;
	}
	public Long getLessonId() {
		return lessonId;
	}
	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}
	public Long getGroupUserId() {
		return groupUserId;
	}
	public void setGroupUserId(Long groupUserId) {
		this.groupUserId = groupUserId;
	}
	public String getGroupUserEmail() {
		return groupUserEmail;
	}
	public void setGroupUserEmail(String groupUserEmail) {
		this.groupUserEmail = groupUserEmail;
	}
}
