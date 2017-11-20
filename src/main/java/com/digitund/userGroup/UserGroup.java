package com.digitund.userGroup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserGroup {
	@Id @GeneratedValue
	private Long id;
	private Long userId;
	private String groupName;
	
	public UserGroup () {}
	
	public UserGroup (Long userId, String groupName) {
		this.groupName=groupName;
		this.userId=userId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
