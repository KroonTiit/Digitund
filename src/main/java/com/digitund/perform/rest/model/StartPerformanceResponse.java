package com.digitund.perform.rest.model;

import com.digitund.manage.model.Material;
import java.util.List;

public class StartPerformanceResponse {
  public long orderNr;
  public List<Material> materials;
  public List<QuestionData> questions;
  
public long getOrderNr() {
	return orderNr;
}
public void setOrderNr(long orderNr) {
	this.orderNr = orderNr;
}
public List<Material> getMaterials() {
	return materials;
}
public void setMaterials(List<Material> materials) {
	this.materials = materials;
}
public List<QuestionData> getQuestions() {
	return questions;
}
public void setQuestions(List<QuestionData> questions) {
	this.questions = questions;
}
  

}
