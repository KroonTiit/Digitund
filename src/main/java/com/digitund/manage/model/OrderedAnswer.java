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
  private int orderNr;
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

  public int getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(int orderNr) {
    this.orderNr = orderNr;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
