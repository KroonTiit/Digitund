package com.digitund.manage.rest;

import com.digitund.manage.data.OrderedAnswerRepo;
import com.digitund.manage.model.OrderedAnswer;
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
@RequestMapping("/api/ordered-answers")
public class OrderedAnswerRestController {

  private OrderedAnswerRepo orderedAnswerRepo;

  @Autowired
  public OrderedAnswerRestController(OrderedAnswerRepo orderedAnswerRepo) {
    this.orderedAnswerRepo = orderedAnswerRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{orderedAnswerId}", method = RequestMethod.GET)
  public OrderedAnswer getOrderedAnswer(@PathVariable Long orderedAnswerId) {
    return orderedAnswerRepo.findOne(orderedAnswerId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public OrderedAnswer getByQuestion(
      @RequestParam(required = true, value = "questionId") Long questionId) {
    return orderedAnswerRepo.findByQuestionId(questionId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public OrderedAnswer createOrderedAnswer(@RequestBody OrderedAnswer orderedAnswer) {
    return orderedAnswerRepo.save(orderedAnswer);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{orderedAnswerId}", method = RequestMethod.DELETE)
  public void deleteOrderedAnswer(@PathVariable Long orderedAnswerId) {
    orderedAnswerRepo.delete(orderedAnswerId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.PATCH)
  public String updateOrderedAnswer(@RequestBody OrderedAnswer orderedAnswer) {
    orderedAnswerRepo.save(orderedAnswer);
    return "wat";
  }

}
