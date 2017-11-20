package com.digitund.manage.rest;

import com.digitund.manage.data.AnswerGroupRepo;
import com.digitund.manage.model.AnswerGroup;
import com.digitund.manage.model.AnswerGroupAnswer;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer-groups")
public class AnswerGroupRestController {

  private AnswerGroupRepo answerGroupRepo;

  @Autowired
  public AnswerGroupRestController(AnswerGroupRepo answerGroupRepo) {
    this.answerGroupRepo = answerGroupRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{answerGroupId}", method = RequestMethod.GET)
  public AnswerGroup getAnswerGroup(@PathVariable Long answerGroupId) {
    return answerGroupRepo.findOne(answerGroupId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public JsonArrayBuilder getAllMaterial(
      @RequestParam(required = true, value = "questionId") Long questionId) {
    AnswerGroup answerGroup = answerGroupRepo.findByQuestionId(questionId);

    List<AnswerGroupAnswer> answer = answerGroupRepo.findAnswersById(answerGroup.getId());
    JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    JsonArrayBuilder arrayBuilderResponce = Json.createArrayBuilder();
    JsonObjectBuilder answerbuilder = Json.createObjectBuilder();
    for (AnswerGroupAnswer data : answer) {
      JsonObject answerJson = answerbuilder.add("id", data.getId())
          .add("answerGroupId", data.getAnswerGroupId())
          .add("text", data.getText())
          .build();
      arrayBuilder.add(answerJson);
    }
    JsonObject responceJson = answerbuilder.add("id", answerGroup.getId())
        .add("questionId", answerGroup.getQuestionId())
        .add("text", answerGroup.getText())
        .add("answeroption", arrayBuilder)
        .build();
    arrayBuilderResponce.add(responceJson).build();
    return arrayBuilderResponce;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public AnswerGroup createAnswerGroup(@RequestBody AnswerGroup answerGroup) {
    return answerGroupRepo.save(answerGroup);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.DELETE)
  public void deleteAnswerGroup(@PathVariable Long answerGroupId) {
    answerGroupRepo.delete(answerGroupId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.PATCH)
  public String updateAnswerGroup(@RequestBody AnswerGroup answerGroup) {
    answerGroupRepo.save(answerGroup);
    return "OK";
  }

}
