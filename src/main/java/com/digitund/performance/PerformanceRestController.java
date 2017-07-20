package com.digitund.performance;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PerformanceRestController")
public class PerformanceRestController {
	@Autowired
	private PerformanceRepo performanceRepo;
    @Autowired
    public PerformanceRestController(PerformanceRepo performanceRepo){
    	this.performanceRepo=performanceRepo;
    }
	 //PERFORMANCE
    @RequestMapping(value="/startSession", method = RequestMethod.POST)
    public Performance startSession(@RequestBody Performance performance){
    	Performance per =null;
    	try{
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		Performance session = new Performance(performance.getPerformer_id(), performance.getLesson_id(), timestamp);
    		per = performanceRepo.save(session);
    		return per;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
		
    }
    @RequestMapping(value="/getSession", method = RequestMethod.POST)
    public List<Performance> getSession(@RequestBody Performance performance){
    	List<Performance> responce=null;
    	try{
    		responce=performanceRepo.getPerformance(performance.getPerformer_id(), performance.getLesson_id());
    		return responce;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
    //PERFORMANCE END
}
