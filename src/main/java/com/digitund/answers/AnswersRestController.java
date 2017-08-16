package com.digitund.answers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value="/{questionId}", method = RequestMethod.GET)
    public List<AnswerOptions> getAllQuestionsAnswers(@PathVariable String questionId) {
		List<Long> answer=null;
    	try{
    		answer.add(Long.decode(questionId));
    		return answerOptionsRepo.findAll(answer);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void saveAnswerOption(@RequestBody AnswerOptions answerOption) {
    	try{
//    		AnswerOptions answerOption = new AnswerOptions(questionId, correct, tekst);
    		answerOptionsRepo.save(answerOption);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping(value="/{answerOptionId}{questionId}", method = RequestMethod.DELETE)
    public void deleteAnswerOption(@PathVariable long AnswerOptionId,
    		@PathVariable long QuestionId) {
    	AnswerOptions responce=null;
    	try{
    		responce= new AnswerOptions(AnswerOptionId, QuestionId);
    		answerOptionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping(value="/{updateAnswerOption}", method = RequestMethod.PATCH)
    public String updateAnswerOption(@RequestBody AnswerOptions answerOptions) {
		try{
				answerOptionsRepo.save(answerOptions);
			return "OK";
			
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
			return null;
		}
	}
    //ANSWERS END
}
