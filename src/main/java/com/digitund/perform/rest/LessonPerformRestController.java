package com.digitund.perform.rest;

import com.digitund.perform.rest.model.StartPerformanceResponse;
import com.digitund.perform.service.PerformanceService;
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
  public StartPerformanceResponse startPerformance(@PathVariable Long lessonId) {
    // TODO should call PerformanceService.startPerformance and do logic there.
    // Should query necessary data from repos and assemble Response object there which gets
    // converted to JSON here (automatically?)
    String userId = "userId"; // TODO should be somehow come from the JWT in Authorization header
    return performanceService.startPerformanceResponse(lessonId, userId);
  }

  //@CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping(method = RequestMethod.POST, value = "/{lessonId}/answer")
//    public AnswerQuestionResponse answerQuestion(@RequestBody AnswerData answer, @PathVariable String lessonId) {
//        // TODO should call PerformanceService.answerQuestion and do logic there
//    }
}
