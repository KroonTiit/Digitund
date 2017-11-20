package com.digitund.manage.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lesson {

  @Id
  @GeneratedValue
  private long id;
  private String userId;
  private Timestamp startTime;
  private Timestamp endTime;
  private Timestamp created;
  private String name;
  private String description;

  public Lesson() {
  }

  public Lesson(String userId) {
    this.userId = userId;
  }

  public Lesson(long id, String userId) {
    this.id = id;
    this.userId = userId;
  }

  public Lesson(Timestamp startDate, Timestamp endDate, Timestamp created, String userId) {
    this.startTime = startDate;
    this.endTime = endDate;
    this.created = created;
    this.userId = userId;
  }

  public Lesson(Timestamp startDate, Timestamp created, String userId, String name) {
    this.startTime = startDate;
    this.created = created;
    this.userId = userId;
    this.name = name;
  }

  public Lesson(Timestamp startDate, Timestamp created, String userId, String name,
      String description) {
    this.startTime = startDate;
    this.created = created;
    this.userId = userId;
    this.name = name;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Timestamp getCreated() {
    return created;
  }

  public void setCreated(Timestamp created) {
    this.created = created;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }
}
