package com.digitund.manage.rest;

import java.sql.Timestamp;
import java.util.List;

import com.digitund.manage.model.Performance;
import com.digitund.manage.data.PerformanceRepo;
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
    public PerformanceRestController(PerformanceRepo performanceRepo){
    	this.performanceRepo=performanceRepo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/startSession", method = RequestMethod.POST)
    public Performance startSession(@RequestBody Performance performance){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Performance session = new Performance(performance.getPerformer_id(), performance.getLesson_id(), timestamp);
		return performanceRepo.save(session);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/getSession", method = RequestMethod.GET)
    public List<Performance> getSession(@RequestBody Performance performance){
		return performanceRepo.getPerformance(performance.getPerformer_id(), performance.getLesson_id());
    }
}
