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
    public PerformanceSession createPerformanceSession(@RequestParam(value="performance_id")long performance_id,
		    						@RequestParam(value="question_id")long question_id,
		    						@RequestParam(value="answer_option_id")long answer_option_id){
    	PerformanceSession per= null;
    	try{
    		PerformanceSession performanceSession = new PerformanceSession(performance_id, question_id, answer_option_id);
    		per = performanceSessionRepo.save(performanceSession);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return per;
    }
    @RequestMapping("/getPerformanceSession")
    public List<PerformanceSession> getPerformanceSession(@RequestParam(value="performance_id")long performance_id,
									@RequestParam(value="question_id")long question_id,
									@RequestParam(value="answer_option_id")long answer_option_id){
    	List<PerformanceSession> per =null;
    	try{
    		per = performanceSessionRepo.getPerformanceSession(performance_id, question_id, answer_option_id);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
    	return per;
	}
  //PERFORMANCE SESSION END
}
