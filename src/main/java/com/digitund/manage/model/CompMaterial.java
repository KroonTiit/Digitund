package com.digitund.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE comp_material SET deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 0")
public class CompMaterial {

  @Id
  @GeneratedValue
  private long id;
  private long lessonId;
  private int orderNr;
  private String name;
  private Boolean deleted = false;

  public CompMaterial() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getLessonId() {
    return lessonId;
  }

  public void setLessonId(long lessonId) {
    this.lessonId = lessonId;
  }

  public int getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(int orderNr) {
    this.orderNr = orderNr;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }
}
