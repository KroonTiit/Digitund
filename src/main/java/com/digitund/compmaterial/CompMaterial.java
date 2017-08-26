package com.digitund.compmaterial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CompMaterial {
	@Id @GeneratedValue
	private long id;
	private long lessonId;
	private long orderNr;
	
	public CompMaterial() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getLessonId() {
		return lessonId;
	}
	public void setLessonId(long lessonId) {
		this.lessonId = lessonId;
	}
	public long getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(long orderNr) {
		this.orderNr = orderNr;
	}
}
