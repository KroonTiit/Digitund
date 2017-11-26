package com.digitund.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerGroupAnswer {

  @Id
  @GeneratedValue
  private Long id;
  private String text;

  @ManyToOne
  private AnswerGroup answerGroup;

  public AnswerGroupAnswer() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public AnswerGroup getAnswerGroup() {
    return answerGroup;
  }

  public void setAnswerGroup(AnswerGroup answerGroup) {
    this.answerGroup = answerGroup;
  }
}
