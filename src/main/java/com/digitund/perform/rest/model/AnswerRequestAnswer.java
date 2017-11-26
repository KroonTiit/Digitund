package com.digitund.perform.rest.model;

import java.util.List;
import java.util.Map;

public class AnswerRequestAnswer {

  public Long questionId;
  public List<Long> answerOptions;
  public List<Long> orderedAnswers;
  public Map<Long, List<Long>> answerGroups;

}
