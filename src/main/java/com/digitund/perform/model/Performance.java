package com.digitund.perform.model;

import com.digitund.enums.PerformanceStatus;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Performance {

  @Id
  @GeneratedValue
  private Long id;
  private String performerId;
  private Long lessonId;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  @Enumerated(EnumType.STRING)
  private PerformanceStatus status;
  private int activeOrderNr;

  public Performance() {
  }

  public Performance(String performerId, Long lessonId) {
    this.performerId = performerId;
    this.lessonId = lessonId;
  }

  public Performance(String performerId, Long lessonId, LocalDateTime startDate) {
    this(performerId, lessonId);
    this.startTime = startDate;
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

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public int getActiveOrderNr() {
    return activeOrderNr;
  }

  public void setActiveOrderNr(int activeOrderNr) {
    this.activeOrderNr = activeOrderNr;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public PerformanceStatus getStatus() {
    return status;
  }

  public void setStatus(PerformanceStatus status) {
    this.status = status;
  }
}
