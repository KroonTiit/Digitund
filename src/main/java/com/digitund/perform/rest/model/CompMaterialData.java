package com.digitund.perform.rest.model;

import com.digitund.manage.model.CompMaterial;

public class CompMaterialData {

  public Long id;
  public String name;
  public int orderNr;
  public boolean failed;

  public static CompMaterialData fromModel(CompMaterial compMaterial) {
    CompMaterialData data = new CompMaterialData();
    data.id = compMaterial.getId();
    data.name = compMaterial.getName();
    data.orderNr = compMaterial.getOrderNr();
    return data;
  }
}
