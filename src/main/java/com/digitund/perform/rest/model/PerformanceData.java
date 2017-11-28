package com.digitund.perform.rest.model;

import java.util.List;
import javax.persistence.Transient;

public class PerformanceData {

  public Long performanceId;
  public int activeOrderNr;
  public String status;
  public List<CompMaterialData> compMaterials;

  @Transient
  public Long activeCompMaterialId;

}
