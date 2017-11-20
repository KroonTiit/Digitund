package com.digitund.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderedAnswer {

  @Id
  @GeneratedValue
  private long id;
  private long questionId;
  private long orderNr;
  private String text;

  public OrderedAnswer() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }

  public long getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(long orderNr) {
    this.orderNr = orderNr;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
