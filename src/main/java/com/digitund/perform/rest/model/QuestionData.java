package com.digitund.perform.rest.model;

import java.util.List;

public class QuestionData {

  public Long id;
  public Long compMaterialId;
  public String text;
  public List<AnswerOptionData> answerOptions;
  public OrderedAnswerData orderedAnswers;
  public AnswerGroupData answerGroups;
  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCompMaterialId() {
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
	public List<AnswerOptionData> getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(List<AnswerOptionData> answerOptions) {
		this.answerOptions = answerOptions;
	}
	public OrderedAnswerData getOrderedAnswers() {
		return orderedAnswers;
	}
	public void setOrderedAnswers(OrderedAnswerData orderedAnswers) {
		this.orderedAnswers = orderedAnswers;
	}
	public AnswerGroupData getAnswerGroups() {
		return answerGroups;
	}
	public void setAnswerGroups(AnswerGroupData answerGroups) {
		this.answerGroups = answerGroups;
	}
  
}
