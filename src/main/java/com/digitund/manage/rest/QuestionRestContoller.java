package com.digitund.manage.rest;

import com.digitund.manage.data.QuestionRepo;
import com.digitund.manage.model.Question;
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
@RequestMapping("/api/questions")
public class QuestionRestContoller {

  private QuestionRepo questionRepo;

  @Autowired
  public QuestionRestContoller(QuestionRepo questionRepo) {
    this.questionRepo = questionRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{questionId}", method = RequestMethod.GET)
  public Question getQuestion(@PathVariable Long questionId) {
    return questionRepo.findOne(questionId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public List<Question> getQuestionsByCompMaterial(
      @RequestParam(value = "compMaterialId") Long compMaterialId) {
    return questionRepo.findByCompMaterial(compMaterialId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public Question saveQuestion(@RequestBody Question question) {
    return questionRepo.save(question);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{questionId}", method = RequestMethod.DELETE)
  public void deleteQuestion(@PathVariable Long questionId) {
    questionRepo.delete(questionId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{questionId}", method = RequestMethod.PATCH)
  public void updateQuestion(@RequestBody Question question) {
    questionRepo.save(question);
  }
}
