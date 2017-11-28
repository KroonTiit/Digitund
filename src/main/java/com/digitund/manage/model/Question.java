package com.digitund.manage.model;

import com.digitund.enums.QuestionType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
  @ManyToOne
  private CompMaterial compMaterial;
  private String text;
  @Enumerated(EnumType.STRING)
  private QuestionType type;
  private Boolean deleted = false;

//  public Question() {
//  }
//
//  public Question(Long compMaterial) {
//    this.compMaterial = compMaterial;
//  }
//
//  public Question(Long id, Long compMaterial) {
//    this.id = id;
//    this.compMaterial = compMaterial;
//  }
//
//  public Question(Long compMaterial, String texts) {
//    this.compMaterial = compMaterial;
//    this.text = texts;
//  }
//
//  public Question(Long id, Long compMaterial, String text, QuestionType type) {
//    this.id = id;
//    this.compMaterial = compMaterial;
//    this.text = text;
//    this.type = type;
//  }

  public CompMaterial getCompMaterial() {
    return compMaterial;
  }

  public void setCompMaterial(CompMaterial compMaterial) {
    this.compMaterial = compMaterial;
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
