package com.digitund.perform.rest.model;

import com.digitund.manage.model.Material;
import java.math.BigDecimal;

public class MaterialData {
  public Long id;
  public String name;
  public String description;
  public String type;
  public int orderNr;

  public BigDecimal videoStart;
  public BigDecimal videoEnd;
  public String youtubeId;

  public String imageUrl;

  public String textContent;

  public static MaterialData fromModel(Material material) {
    MaterialData data = new MaterialData();
    data.id = material.getId();
    data.name = material.getName();
    data.type = material.getType().name();
    data.orderNr = material.getOrderNr();
    data.description = material.getDescription();
    data.imageUrl = material.getImageUrl();
    data.textContent = material.getTextContent();
    data.youtubeId = material.getYoutubeId();
    data.videoStart = material.getVideoStart();
    data.videoEnd = material.getVideoEnd();
    return data;
  }
}
