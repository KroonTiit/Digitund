package com.digitund.tekst;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Tekst {
	@Id @GeneratedValue
	private Long id;
	private Long lesson_id;
	private Long order_nr;
	private String tekst;
	
	public Tekst (){}
	public Tekst (Long lesson_id) {
		this.lesson_id=lesson_id;
	}
	public Tekst (Long id, Long lesson_id) {
		this.id=id;
		this.lesson_id=lesson_id;
	}
	public Tekst (Long id, Long lesson_id, Long order_nr, String tekst){
		this.id=id;
		this.lesson_id=lesson_id;
		this.order_nr=order_nr;
		this.tekst=tekst;
	}
	public Tekst (Long lesson_id,Long order_nr,String tekst){
		this.lesson_id=lesson_id;
		this.order_nr=order_nr;
		this.tekst=tekst;
	}
	
	public long getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(Long lesson_id) {
		this.lesson_id = lesson_id;
	}
	public long getOrder_nr() {
		return order_nr;
	}
	public void setOrder_nr(Long order_nr) {
		this.order_nr = order_nr;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
}
