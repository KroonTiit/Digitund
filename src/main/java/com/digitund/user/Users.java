package com.digitund.user;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Users {
	@Id @GeneratedValue
	private Long id;
	private Timestamp start_date ;
	private Timestamp end_date;
	
	public Users(){};
	public Users(Long id){
		this.id=id;
	}
	public Users(Timestamp start_date){
		this.start_date=start_date;
	}
	public Users(long id,  Timestamp start_date, Timestamp end_date){
		this.id=id;
		this.start_date=start_date;
		this.end_date=end_date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}
	public Timestamp getStart_date() {
		return start_date;
	}
	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
}
