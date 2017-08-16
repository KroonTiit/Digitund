package com.digitund.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Questions {
	@Id @GeneratedValue
	private Long id;
	private Long materialId;
	private Long orderNr;
	private String text;
	private String type;
	
	public Questions(){}
	public Questions(Long materialId){
		this.materialId=materialId;
	}
	public Questions(Long id, Long materialId){
		this.id=id;
		this.materialId=materialId;
	}
	public Questions(Long materialId, Long orderNr, String texts){
		this.materialId=materialId;
		this.orderNr=orderNr;
		this.text=text;
	}
	public Questions(Long id, Long materialId, Long orderNr, String text){
		this.id=id;
		this.materialId=materialId;
		this.orderNr=orderNr;
		this.text=text;
	}
	public Questions(Long id, Long materialId, Long orderNr, String text, String type){
		this.id=id;
		this.materialId=materialId;
		this.orderNr=orderNr;
		this.text=text;
		this.type=type;
	}
	public long getMaterial_id() {
		return materialId;
	}
	public void setMaterial_id(Long materialId) {
		this.materialId = materialId;
	}
	public long getOrder_nr() {
		return orderNr;
	}
	public void setOrder_nr(Long orderNr) {
		this.orderNr = orderNr;
	}
	public String getTekst() {
		return text;
	}
	public void setTekst(String tekst) {
		this.text = tekst;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
