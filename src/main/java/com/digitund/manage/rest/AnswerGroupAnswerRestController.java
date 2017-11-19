package com.digitund.manage.rest;

import java.util.List;

import com.digitund.manage.model.AnswerGroupAnswer;
import com.digitund.manage.data.AnswerGroupAnswerRepo;
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
public class AnswerGroupAnswerRestController {

	private AnswerGroupAnswerRepo answerGroupAnswersRepo;

	@Autowired 
	public AnswerGroupAnswerRestController(AnswerGroupAnswerRepo answerGroupAnswersRepo){
		this.answerGroupAnswersRepo=answerGroupAnswersRepo;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{answerGroupAnswerId}", method = RequestMethod.GET)
	 public AnswerGroupAnswer getAnswerGroupAnswer(@PathVariable String answerGroupAnswerId) {
		return answerGroupAnswersRepo.findOne(Long.decode(answerGroupAnswerId));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
	public List<AnswerGroupAnswer> getByAnswerGroupId(@RequestParam(required=true,value="answerGroupId") String answerGroupId) {
		return answerGroupAnswersRepo.findByAnswerGroupId(Long.decode(answerGroupId));
	}
	
	//POST
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.POST)
	public AnswerGroupAnswer createAnswerGroupAnswer(@RequestBody AnswerGroupAnswer answerGroupAnswer) {
		return answerGroupAnswersRepo.save(answerGroupAnswer);
	}
	
	//DELETE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{materialId}",method = RequestMethod.DELETE)
	public void deleteAnswerGroupAnswer(@PathVariable String answerGroupAnswer) {
		answerGroupAnswersRepo.delete(Long.decode(answerGroupAnswer));
	}
	
	//UPDATE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{materialId}",method = RequestMethod.PATCH)
	public String updateMaterial(@RequestBody AnswerGroupAnswer answerGroupAnswer) {
		answerGroupAnswersRepo.save(answerGroupAnswer);
		return "OK";
    }
	
}
