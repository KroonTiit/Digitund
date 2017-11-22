package com.digitund.perform.rest.model;

import com.digitund.manage.model.OrderedAnswer;

public class OrderedAnswerData {

  public Long id;
  public String text;

  public static OrderedAnswerData fromModel(OrderedAnswer orderedAnswer) {
    OrderedAnswerData data = new OrderedAnswerData();
    data.id = orderedAnswer.getId();
    data.text = orderedAnswer.getText();
    return data;
  }
  
}
