package com.digitund.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Questions {
	@Id @GeneratedValue
	private Long id;
	
	private Long compMaterialId;
	private Long orderNr;
	private String text;
	private String type;
	
	public Questions(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getMaterial_id() {
		return compMaterialId;
	}
	public void setMaterial_id(Long materialId) {
		this.compMaterialId = materialId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCompMaterialId() {
		return compMaterialId;
	}
	public void setCompMaterialId(Long compMaterialId) {
		this.compMaterialId = compMaterialId;
	}
	public Long getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(Long orderNr) {
		this.orderNr = orderNr;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
