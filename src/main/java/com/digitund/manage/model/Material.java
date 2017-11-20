package com.digitund.manage.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE material SET deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 0")
public class Material {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private long compMaterialId;
  private long orderNr;
  private String type;
  private String textContent;
  private BigDecimal videoStart;
  private BigDecimal videoEnd;
  private String youtubeId;
  private String imageUrl;
  private String description;
  private Boolean deleted = false;

  public Material() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCompMaterialId() {
    return compMaterialId;
  }

  public void setCompMaterialId(long compMaterialId) {
    this.compMaterialId = compMaterialId;
  }

  public long getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(long orderNr) {
    this.orderNr = orderNr;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTextContent() {
    return textContent;
  }

  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }

  public BigDecimal getVideoStart() {
    return videoStart;
  }

  public void setVideoStart(BigDecimal videoStart) {
    this.videoStart = videoStart;
  }

  public BigDecimal getVideoEnd() {
    return videoEnd;
  }

  public void setVideoEnd(BigDecimal videoEnd) {
    this.videoEnd = videoEnd;
  }

  public String getYoutubeId() {
    return youtubeId;
  }

  public void setYoutubeId(String youtubeId) {
    this.youtubeId = youtubeId;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
