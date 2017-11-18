package com.digitund.manage.rest;

import java.util.List;

import com.digitund.manage.model.AnswerOption;
import com.digitund.manage.data.AnswerOptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answeroption")
public class AnswerOptionRestController {

	@Autowired 
	private AnswerOptionRepo answerOptionRepo;
	
    @Autowired
    public AnswerOptionRestController(AnswerOptionRepo answerOptionRepo){
    	this.answerOptionRepo = answerOptionRepo;
    	
    }
   
    //ANSWERS
    @CrossOrigin(origins ="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    public List<AnswerOption> getAllQuestionsAnswers(@RequestParam(required=true,value="questionId")String id) {
    	try{
    		return answerOptionRepo.findByQuestionId(Long.decode(id));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public void saveAnswerOption(@RequestBody AnswerOption answerOption) {
    	try{
    		answerOptionRepo.save(answerOption);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{answerId}", method=RequestMethod.DELETE)
    public void deleteAnswerOption(@PathVariable String answerId) {
    	try{
    		answerOptionRepo.delete(Long.decode(answerId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{answerId}", method = RequestMethod.PATCH)
    public String updateAnswerOption(@RequestBody AnswerOption answerId) {
		try{
			answerOptionRepo.save(answerId);
			return "OK";
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
			return null;
		}
	}
    //ANSWERS END
}
