package com.digitund.questins;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Questions {
	@Id @GeneratedValue
	private Long id;
	private Long material_id;
	private Long order_nr;
	private String tekst;
	
	public Questions(){}
	public Questions(Long material_id){
		this.material_id=material_id;
	}
	public Questions(Long id, Long material_id){
		this.id=id;
		this.material_id=material_id;
	}
	public Questions(Long material_id, Long order_nr, String tekst){
		this.material_id=material_id;
		this.order_nr=order_nr;
		this.tekst=tekst;
	}
	public Questions(Long id, Long material_id, Long order_nr, String tekst){
		this.id=id;
		this.material_id=material_id;
		this.order_nr=order_nr;
		this.tekst=tekst;
	}
	
	public long getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Long material_id) {
		this.material_id = material_id;
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
