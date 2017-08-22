package com.digitund.answers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AnswersRestController")
public class AnswersRestController {

	@Autowired 
	private AnswerOptionsRepo answerOptionsRepo;	
	
    @Autowired
    public AnswersRestController( AnswerOptionsRepo answerOptionsRepo){
    	this.answerOptionsRepo=answerOptionsRepo;
    	
    }
   
    //ANSWERS
    @CrossOrigin(origins ="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    public List<AnswerOptions> getAllQuestionsAnswers(@RequestParam(required=true,value="questionId")String id) {
    	try{
    		return answerOptionsRepo.findByQuestionId(Long.decode(id));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public void saveAnswerOption(@RequestBody AnswerOptions answerOption) {
    	try{
    		answerOptionsRepo.save(answerOption);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{answerId}", method=RequestMethod.DELETE)
    public void deleteAnswerOption(@PathVariable String answerId) {
    	try{
    		answerOptionsRepo.delete(Long.decode(answerId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{answerId}", method = RequestMethod.PATCH)
    public String updateAnswerOption(@RequestBody AnswerOptions answerId) {
		try{
			answerOptionsRepo.save(answerId);
			return "OK";
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
			return null;
		}
	}
    //ANSWERS END
}
