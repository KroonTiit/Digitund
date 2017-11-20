package com.digitund.manage.rest;

import com.digitund.manage.data.AnswerOptionRepo;
import com.digitund.manage.model.AnswerOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer-options")
public class AnswerOptionRestController {

  private AnswerOptionRepo answerOptionRepo;

  @Autowired
  public AnswerOptionRestController(AnswerOptionRepo answerOptionRepo) {
    this.answerOptionRepo = answerOptionRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public List<AnswerOption> getAllQuestionsAnswers(
      @RequestParam(required = true, value = "questionId") Long id) {
    return answerOptionRepo.findByQuestionId(id);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public void saveAnswerOption(@RequestBody AnswerOption answerOption) {
    answerOptionRepo.save(answerOption);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{answerId}", method = RequestMethod.DELETE)
  public void deleteAnswerOption(@PathVariable Long answerId) {
    answerOptionRepo.delete(answerId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{answerId}", method = RequestMethod.PATCH)
  public String updateAnswerOption(@RequestBody AnswerOption answerId) {
    answerOptionRepo.save(answerId);
    return "OK";
  }
}
