package com.digitund.user;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Users {
	@Id @GeneratedValue
	private Long id;
	private Timestamp startDate ;
	private Timestamp endDate;
	
	public Users(){};
	public Users(Long id){
		this.id=id;
	}
	public Users(Timestamp startDate){
		this.startDate=startDate;
	}
	public Users(long id,  Timestamp startDate, Timestamp endDate){
		this.id=id;
		this.startDate=startDate;
		this.endDate=endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getEnd_date() {
		return endDate;
	}
	public void setEnd_date(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Timestamp getStart_date() {
		return startDate;
	}
	public void setStart_date(Timestamp startDate) {
		this.startDate = startDate;
	}
}
