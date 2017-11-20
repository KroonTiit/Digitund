package com.digitund.perform.rest.model;

import java.util.List;

public class QuestionData {
    public Long id;
    public Long compMaterialId;
    public List<AnswerOptionData> answerOptions;
    public List<OrderedAnswerData> orderedAnswers;
    public List<AnswerGroupData> answerGroups;
    public List<AnswerGroupAnswerData> answerGroupAnswers;
}
