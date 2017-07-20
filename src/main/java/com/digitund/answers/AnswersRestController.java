package com.digitund.answers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/getAllAnswerOptions")
    public List<AnswerOptions> getAllQuestionsAnswers(@RequestParam(value="questionId")long questionId) {
		List<AnswerOptions> responce=null;
		List<Long> answer=null;
    	try{
    		answer.add(questionId);
    		responce = answerOptionsRepo.findAll(answer);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping(value="/saveAnswerOption", method = RequestMethod.POST)
    public void saveAnswerOption(@RequestBody AnswerOptions answerOption) {
    	try{
//    		AnswerOptions answerOption = new AnswerOptions(questionId, correct, tekst);
    		answerOptionsRepo.save(answerOption);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteAnswerOption")
    public void deleteAnswerOption(@RequestParam(value="id")long id,
    		@RequestParam(value="question_id")long questionId) {
    	AnswerOptions responce=null;
    	try{
    		responce= new AnswerOptions(id, questionId);
    		answerOptionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/updateAnswerOption")
    public void updateAnswerOption(@RequestParam(value="id")Long id,
    						@RequestParam(value="questionId")Long questionId,
    						@RequestParam(value="tekst")String tekst,
							 @RequestParam(value="correct")boolean correct) {
		try{
			AnswerOptions newAnswer= new AnswerOptions(id, questionId, correct, tekst);
			AnswerOptions updateAnswer = answerOptionsRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newAnswer.getQuestion_id()).equals(null)){
				updateAnswer.setQuestion_id(questionId);
				change=true;
			}
			if(!((Boolean)newAnswer.isCorrect()).equals(null)){
				updateAnswer.setCorrect(correct);
				change=true;
			}
			if(!((String)newAnswer.getTekst()).equals(null)){
				updateAnswer.setTekst(tekst);
				change=true;
			}
			if(change){
				answerOptionsRepo.save(updateAnswer);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //ANSWERS END
}
