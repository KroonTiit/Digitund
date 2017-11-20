package com.digitund.manage.model;

import javax.persistence.Entity;
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
  private String type;
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

  public Question(Long id, Long compMaterialId, String text, String type) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
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
