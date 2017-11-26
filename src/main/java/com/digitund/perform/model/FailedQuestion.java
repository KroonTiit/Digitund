package com.digitund.perform.model;

import com.digitund.enums.QuestionType;
import com.digitund.perform.rest.model.AnswerRequestAnswer;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class FailedQuestion {

  @Id
  @GeneratedValue
  private Long id;
  private LocalDateTime failTime;
  private Long performanceId;
  @Enumerated(EnumType.STRING)
  private QuestionType questionType;
  /**
   * See https://vladmihalcea.com/2016/06/20/how-to-map-json-objects-using-generic-hibernate-types/
   * for details
   */
  @Type(type = "com.vladmihalcea.hibernate.type.json.JsonStringType")
  @Column(columnDefinition = "json")
  private AnswerRequestAnswer answerJson;
  private boolean corrected;
  private Long compMaterialId;
  private int orderNr;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getFailTime() {
    return failTime;
  }

  public void setFailTime(LocalDateTime failTime) {
    this.failTime = failTime;
  }

  public Long getPerformanceId() {
    return performanceId;
  }

  public void setPerformanceId(Long performanceId) {
    this.performanceId = performanceId;
  }

  public QuestionType getQuestionType() {
    return questionType;
  }

  public void setQuestionType(QuestionType questionType) {
    this.questionType = questionType;
  }

  public AnswerRequestAnswer getAnswerJson() {
    return answerJson;
  }

  public void setAnswerJson(AnswerRequestAnswer answerJson) {
    this.answerJson = answerJson;
  }

  public boolean isCorrected() {
    return corrected;
  }

  public void setCorrected(boolean corrected) {
    this.corrected = corrected;
  }

  public Long getCompMaterialId() {
    return compMaterialId;
  }

  public void setCompMaterialId(Long compMaterialId) {
    this.compMaterialId = compMaterialId;
  }

  public int getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(int orderNr) {
    this.orderNr = orderNr;
  }
}
