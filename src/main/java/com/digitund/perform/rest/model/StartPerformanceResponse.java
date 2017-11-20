package com.digitund.perform.rest.model;

import com.digitund.manage.model.Material;
import java.util.List;

public class StartPerformanceResponse {

  public int orderNr;
  public List<Material> materials;
  public List<QuestionData> questions;

}
