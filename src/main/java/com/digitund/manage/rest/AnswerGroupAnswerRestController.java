package com.digitund.manage.rest;

import com.digitund.manage.data.AnswerGroupAnswerRepo;
import com.digitund.manage.model.AnswerGroupAnswer;
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
@RequestMapping("/api/answer-group-answers")
public class AnswerGroupAnswerRestController {

  private AnswerGroupAnswerRepo answerGroupAnswersRepo;

  @Autowired
  public AnswerGroupAnswerRestController(AnswerGroupAnswerRepo answerGroupAnswersRepo) {
    this.answerGroupAnswersRepo = answerGroupAnswersRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{answerGroupAnswerId}", method = RequestMethod.GET)
  public AnswerGroupAnswer getAnswerGroupAnswer(@PathVariable Long answerGroupAnswerId) {
    return answerGroupAnswersRepo.findOne(answerGroupAnswerId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public List<AnswerGroupAnswer> getByAnswerGroupId(
      @RequestParam(required = true, value = "answerGroupId") Long answerGroupId) {
    return answerGroupAnswersRepo.findByAnswerGroupId(answerGroupId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public AnswerGroupAnswer createAnswerGroupAnswer(
      @RequestBody AnswerGroupAnswer answerGroupAnswer) {
    return answerGroupAnswersRepo.save(answerGroupAnswer);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{answerId}", method = RequestMethod.DELETE)
  public void deleteAnswerGroupAnswer(@PathVariable Long answerId) {
    answerGroupAnswersRepo.delete(answerId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.PATCH)
  public String updateMaterial(@RequestBody AnswerGroupAnswer answerGroupAnswer) {
    answerGroupAnswersRepo.save(answerGroupAnswer);
    return "OK";
  }

}
