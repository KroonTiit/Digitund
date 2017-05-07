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
    public Performance startSession(@RequestParam(value="performer_id")long performer_id,
    						@RequestParam(value="lesson_id")long lesson_id){
    	Performance per =null;
    	try{
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		Performance session = new Performance(performer_id, lesson_id, timestamp);
    		per = performanceRepo.save(session);
    		
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
		return per;
    }
    @RequestMapping("/getSession")
    public List<Performance> getSession(@RequestParam(value="performer_id")Long performer_id,
    						@RequestParam(value="lesson_id")Long lesson_id){
    	List<Performance> responce=null;
    	try{
    		Performance session = new Performance(performer_id, lesson_id);
    		
    		responce=performanceRepo.getPerformance(performer_id, lesson_id);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    //PERFORMANCE END
}
