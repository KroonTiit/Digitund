package com.digitund.manage.model;

import com.digitund.enums.QuestionType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE question SET deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 0")
public class Question {

  @Id
  @GeneratedValue
  private Long id;
  private Long compMaterialId;
  private String text;
  @Enumerated(EnumType.STRING)
  private QuestionType type;
  private Boolean deleted = false;

  public Question() {
  }

  public Question(Long compMaterialId) {
    this.compMaterialId = compMaterialId;
  }

  public Question(Long id, Long compMaterialId) {
    this.id = id;
    this.compMaterialId = compMaterialId;
  }

  public Question(Long compMaterialId, String texts) {
    this.compMaterialId = compMaterialId;
    this.text = texts;
  }

  public Question(Long id, Long compMaterialId, String text, QuestionType type) {
    this.id = id;
    this.compMaterialId = compMaterialId;
    this.text = text;
    this.type = type;
  }

  public long getCompMaterialId() {
    return compMaterialId;
  }

  public void setCompMaterialId(Long compMaterialId) {
    this.compMaterialId = compMaterialId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public QuestionType getType() {
    return type;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }
}
