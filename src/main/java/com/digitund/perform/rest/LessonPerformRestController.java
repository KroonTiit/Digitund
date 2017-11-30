package com.digitund.perform.rest;

import com.digitund.perform.rest.model.AnswerRequest;
import com.digitund.perform.rest.model.AnswerQuestionResponse;
import com.digitund.perform.rest.model.StartPerformanceResponse;
import com.digitund.perform.service.PerformanceService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/perform-lesson")
public class LessonPerformRestController {

  private final PerformanceService performanceService;

  @Autowired
  public LessonPerformRestController(PerformanceService performanceService) {
    this.performanceService = performanceService;
  }

  @CrossOrigin(origins = "http://localhost:3000") // TODO this needs to be fixed
  @RequestMapping(method = RequestMethod.POST, value = "/{lessonId}/start")
  public StartPerformanceResponse startPerformance(Principal principal, @PathVariable Long lessonId) {
    return performanceService.startPerformance(lessonId, principal.getName());
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST, value = "/{lessonId}/answer")
  public AnswerQuestionResponse answerQuestion(
      Principal principal,
      @RequestBody AnswerRequest answer,
      @PathVariable Long lessonId
  ) {
    return performanceService.answerQuestion(answer, lessonId, principal.getName());
  }
}
