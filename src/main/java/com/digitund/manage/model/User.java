package com.digitund.manage.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue
  private Long id;
  private Timestamp startDate;
  private Timestamp endDate;

  public User() {
  }

  public User(Long id) {
    this.id = id;
  }

  public User(Timestamp startDate) {
    this.startDate = startDate;
  }

  public User(long id, Timestamp startDate, Timestamp endDate) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }
}
