package com.digitund.manage.rest;

import java.util.List;

import com.digitund.manage.model.Question;
import com.digitund.manage.data.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionRestContoller {

	@Autowired 
	private QuestionRepo questionRepo;
	@Autowired 
	public QuestionRestContoller(QuestionRepo questionRepo){
		this.questionRepo = questionRepo;
	}
	
	 //QUESTIONS
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
    public List<Question> getAllMaterialQuestions(@RequestParam(required=true,value="materialId")String id) {
    	try{
    		return questionRepo.findAll(Long.decode(id));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public void saveQuestion(@RequestBody Question question) {
    	try{
    		questionRepo.save(question);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{questionId}",method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable String questionId) {
    	try{
    		questionRepo.delete(Long.decode(questionId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{questionId}", method = RequestMethod.PATCH)
    public void updateQuestion(@RequestBody Question question) {
		try{
				questionRepo.save(question);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
}
