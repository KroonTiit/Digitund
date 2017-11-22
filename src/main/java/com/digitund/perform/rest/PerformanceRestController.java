package com.digitund.perform.rest;

import com.digitund.perform.data.PerformanceRepo;
import com.digitund.perform.model.Performance;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/performances")
public class PerformanceRestController {

  private PerformanceRepo performanceRepo;

  @Autowired
  public PerformanceRestController(PerformanceRepo performanceRepo) {
    this.performanceRepo = performanceRepo;
  }

}
