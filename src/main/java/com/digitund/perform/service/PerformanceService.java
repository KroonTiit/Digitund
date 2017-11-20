package com.digitund.perform.service;

import com.digitund.perform.rest.model.StartPerformanceResponse;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

  public StartPerformanceResponse startPerformanceResponse(Long lessonId, String userId) {
    // TODO query and assemble data
    return new StartPerformanceResponse();
  }

}
