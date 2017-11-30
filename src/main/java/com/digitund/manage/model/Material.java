package com.digitund.manage.model;

import com.digitund.enums.MaterialType;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
  private Long id;
  private String name;
  private Long compMaterialId;
  private int orderNr;
  @Enumerated(EnumType.STRING)
  private MaterialType type;
  private String textContent;
  private BigDecimal videoStart;
  private BigDecimal videoEnd;
  private String youtubeId;
  private String imageUrl;
  private String description;
  private Boolean deleted = false;

  public Material() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getCompMaterialId() {
    return compMaterialId;
  }

  public void setCompMaterialId(long compMaterialId) {
    this.compMaterialId = compMaterialId;
  }

  public int getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(int orderNr) {
    this.orderNr = orderNr;
  }

  public MaterialType getType() {
    return type;
  }

  public void setType(MaterialType type) {
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
