package com.digitund.questins;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Questions {
	@Id @GeneratedValue
	private Long id;
	private Long materialId;
	private Long orderNr;
	private String tekst;
	
	public Questions(){}
	public Questions(Long materialId){
		this.materialId=materialId;
	}
	public Questions(Long id, Long materialId){
		this.id=id;
		this.materialId=materialId;
	}
	public Questions(Long materialId, Long orderNr, String tekst){
		this.materialId=materialId;
		this.orderNr=orderNr;
		this.tekst=tekst;
	}
	public Questions(Long id, Long materialId, Long orderNr, String tekst){
		this.id=id;
		this.materialId=materialId;
		this.orderNr=orderNr;
		this.tekst=tekst;
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
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
}
