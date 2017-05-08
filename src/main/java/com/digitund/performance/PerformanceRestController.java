package com.digitund.performance;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/startSession")
    public Performance startSession(@RequestParam(value="performerId")long performerId,
    						@RequestParam(value="lessonId")long lessonId){
    	Performance per =null;
    	try{
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		Performance session = new Performance(performerId, lessonId, timestamp);
    		per = performanceRepo.save(session);
    		
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
		return per;
    }
    @RequestMapping("/getSession")
    public List<Performance> getSession(@RequestParam(value="performerId")long performerId,
    						@RequestParam(value="lessonId")long lessonId){
    	List<Performance> responce=null;
    	try{
    		responce=performanceRepo.getPerformance(performerId, lessonId);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    //PERFORMANCE END
}
