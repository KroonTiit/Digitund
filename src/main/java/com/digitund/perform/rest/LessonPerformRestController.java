package com.digitund.perform.rest;

import com.digitund.perform.rest.model.StartPerformanceResponse;
import com.digitund.perform.service.PerformanceService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/perform-lesson")
public class LessonPerformRestController {

  @Autowired
  private PerformanceService performanceService;

  //@CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST, value = "/{lessonId}/start")
  public StartPerformanceResponse startPerformance(Principal principal, @PathVariable Long lessonId) {
    String userId = principal.getName(); // TODO user ID retrieving needs to be looked into.
    return performanceService.startPerformance(lessonId, userId);
  }

  //@CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping(method = RequestMethod.POST, value = "/{lessonId}/answer")
//    public AnswerQuestionResponse answerQuestion(@RequestBody AnswerData answer, @PathVariable String lessonId) {
//        // TODO should call PerformanceService.answerQuestion and do logic there
//    }
}
