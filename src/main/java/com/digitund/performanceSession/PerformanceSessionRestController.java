package com.digitund.performanceSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PerformanceSessionRestController")
public class PerformanceSessionRestController {
	@Autowired
	private PerformanceSessionRepo performanceSessionRepo;
	@Autowired
    public PerformanceSessionRestController(PerformanceSessionRepo performanceSessionRepo){
		this.performanceSessionRepo=performanceSessionRepo;
	}
	
	  //PERFORMANCE SESSION
    @RequestMapping("/savePerformanceSession")
    public PerformanceSession createPerformanceSession(@RequestParam(value="performanceId")long performanceId,
		    						@RequestParam(value="questionId")long questionId,
		    						@RequestParam(value="answerOptionId")long answerOptionId){
    	PerformanceSession per= null;
    	try{
    		PerformanceSession performanceSession = new PerformanceSession(performanceId, questionId, answerOptionId);
    		per = performanceSessionRepo.save(performanceSession);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return per;
    }
    @RequestMapping("/getPerformanceSession")
    public List<PerformanceSession> getPerformanceSession(@RequestParam(value="performanceId")long performanceId,
									@RequestParam(value="questionId")long questionId,
									@RequestParam(value="answerOptionId")long answerOptionId){
    	List<PerformanceSession> per =null;
    	try{
    		per = performanceSessionRepo.getPerformanceSession(performanceId, questionId, answerOptionId);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
    	return per;
	}
  //PERFORMANCE SESSION END
}
