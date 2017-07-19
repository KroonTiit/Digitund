package com.digitund.performanceSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public PerformanceSession createPerformanceSession(@RequestBody PerformanceSession performanceSession
//    		Param(value="performanceId")long performanceId,
//		    						@RequestParam(value="questionId")long questionId,
//		    						@RequestParam(value="answerOptionId")long answerOptionId
		    						){
    	PerformanceSession per= null;
    	try{
    		PerformanceSession newPerformanceSession = new PerformanceSession(performanceSession.getPerformance_id(), performanceSession.getQuestions_id(), performanceSession.getAnswer_options_id());
    		per = performanceSessionRepo.save(newPerformanceSession);
    		return per;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    @RequestMapping("/getPerformanceSession")
    public List<PerformanceSession> getPerformanceSession(@RequestBody PerformanceSession performanceSession
//    		Param(value="performanceId")long performanceId,
//									@RequestParam(value="questionId")long questionId,
//									@RequestParam(value="answerOptionId")long answerOptionId
									){
    	List<PerformanceSession> per =null;
    	try{
    		per = performanceSessionRepo.getPerformanceSession(performanceSession.getPerformance_id(), performanceSession.getQuestions_id(), performanceSession.getAnswer_options_id());
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
    	return per;
	}
  //PERFORMANCE SESSION END
}
