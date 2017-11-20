package com.digitund.answerGroupAnswer;

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
@RequestMapping("/api/answer-group-answers")
public class AnswerGroupAnswersRestController {
	@Autowired 
	private AnswerGroupAnswerRepo answerGroupAnswersRepo;
	@Autowired 
	public AnswerGroupAnswersRestController (AnswerGroupAnswerRepo answerGroupAnswersRepo){
		this.answerGroupAnswersRepo=answerGroupAnswersRepo;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{answerGroupAnswersId}", method = RequestMethod.GET)
	 public AnswerGroupAnswer getAnswerGroupAnswers(@PathVariable String materialId) {
		try {
			return answerGroupAnswersRepo.findOne(Long.decode(materialId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
	 public List<AnswerGroupAnswer> getAllAnswerGroupAnswers(@RequestParam(required=true,value="answerGroupAnswers") String answerGroupAnswers) {
		try {
			return answerGroupAnswersRepo.findByAnswerGroupId(Long.decode(answerGroupAnswers));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	//POST
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.POST)
	public AnswerGroupAnswer createAnswerGroupAnswers(@RequestBody AnswerGroupAnswer answerGroupAnswers) {
		try {
			return answerGroupAnswersRepo.save(answerGroupAnswers);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	//DELETE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{answerGroupAnswersId}",method = RequestMethod.DELETE)
	public void deleteAnswerGroupAnswers(@PathVariable String answerGroupAnswers) {
		try {
			answerGroupAnswersRepo.delete(Long.decode(answerGroupAnswers));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	//UPDATE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{answerGroupAnswersId}",method = RequestMethod.PATCH)
	public String updateAnswerGroupAnswers(@RequestBody AnswerGroupAnswer answerGroupAnswers) {
    	try{
    		answerGroupAnswersRepo.save(answerGroupAnswers);
    		return "OK";
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return "not OK";
		}
    }
	
}
