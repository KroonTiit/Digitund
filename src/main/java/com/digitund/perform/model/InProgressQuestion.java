package com.digitund.perform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InProgressQuestion {

  @Id
  @GeneratedValue
  private Long id;
  private Long questionId;
  private Long performanceId;

  public InProgressQuestion() {
    //
  }

  public InProgressQuestion(Long questionId, Long performanceId) {
    this.questionId = questionId;
    this.performanceId = performanceId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getPerformanceId() {
    return performanceId;
  }

  public void setPerformanceId(Long performanceId) {
    this.performanceId = performanceId;
  }
}
