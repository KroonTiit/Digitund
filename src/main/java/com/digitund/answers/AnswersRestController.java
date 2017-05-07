package com.digitund.answers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<AnswerOptions> getAllQuestionsAnswers(@RequestParam(value="question_id")long question_id) {
		List<AnswerOptions> responce=null;
		List<Long> answer=null;
    	try{
    		answer.add(question_id);
    		responce = answerOptionsRepo.findAll(answer);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveAnswerOption")
    public void saveAnswerOption(@RequestParam(value="question_id")Long question_id,
    							 @RequestParam(value="tekst")String tekst,
    							 @RequestParam(value="correct")boolean correct) {
    	try{
    		AnswerOptions answerOption = new AnswerOptions(question_id, correct, tekst);
    		answerOptionsRepo.save(answerOption);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteAnswerOption")
    public void deleteAnswerOption(@RequestParam(value="id")long id,
    		@RequestParam(value="question_id")long question_id) {
    	AnswerOptions responce=null;
    	try{
    		responce= new AnswerOptions(id, question_id);
    		answerOptionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/updateAnswerOption")
    public void updateAnswerOption(@RequestParam(value="id")Long id,
    						@RequestParam(value="question_id")Long question_id,
    						@RequestParam(value="tekst")String tekst,
							 @RequestParam(value="correct")boolean correct) {
		try{
			AnswerOptions newAnswer= new AnswerOptions(id, question_id, correct, tekst);
			AnswerOptions updateAnswer = answerOptionsRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newAnswer.getQuestion_id()).equals(null)){
				updateAnswer.setQuestion_id(question_id);
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
