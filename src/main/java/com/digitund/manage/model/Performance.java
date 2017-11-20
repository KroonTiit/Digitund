package com.digitund.manage.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Performance {

  @Id
  @GeneratedValue
  private Long id;
  private String performerId;
  private Long lessonId;
  private Timestamp startDate;

  public Performance() {
  }

  public Performance(String performerId, Long lessonId) {
    this.performerId = performerId;
    this.lessonId = lessonId;
  }

  public Performance(String performerId, Long lessonId, Timestamp startDate) {
    this(performerId, lessonId);
    this.startDate = startDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPerformerId() {
    return performerId;
  }

  public void setPerformerId(String performerId) {
    this.performerId = performerId;
  }

  public Long getLessonId() {
    return lessonId;
  }

  public void setLessonId(Long lessonId) {
    this.lessonId = lessonId;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }
}
