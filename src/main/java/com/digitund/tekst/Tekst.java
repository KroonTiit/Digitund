package com.digitund.tekst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Tekst {
	@Id @GeneratedValue
	private Long id;
	private Long lessonId;
	private Long orderNr;
	private String tekst;
	
	public Tekst (){}
	public Tekst (Long lessonId) {
		this.lessonId=lessonId;
	}
	public Tekst (Long id, Long lessonId) {
		this.id=id;
		this.lessonId=lessonId;
	}
	public Tekst (Long id, Long lessonId, Long orderNr, String tekst){
		this.id=id;
		this.lessonId=lessonId;
		this.orderNr=orderNr;
		this.tekst=tekst;
	}
	public Tekst (Long lesson_id,Long orderNr,String tekst){
		this.lessonId=lessonId;
		this.orderNr=orderNr;
		this.tekst=tekst;
	}
	
	public long getLesson_id() {
		return lessonId;
	}
	public void setLesson_id(Long lessonId) {
		this.lessonId = lessonId;
	}
	public long getOrder_nr() {
		return orderNr;
	}
	public void setOrder_nr(Long orderNr) {
		this.orderNr = orderNr;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
}
