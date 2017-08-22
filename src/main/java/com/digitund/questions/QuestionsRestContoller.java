package com.digitund.questions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitund.video.Video;

@RestController
@RequestMapping("/api/questionsRestContoller")
public class QuestionsRestContoller {

	@Autowired 
	private QuestionsRepo questionsRepo;
	@Autowired 
	public QuestionsRestContoller(QuestionsRepo questionsRepo){
		this.questionsRepo=questionsRepo;
	}
	
	 //QUESTIONS
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
    public List<Video> getAllMaterialQuestions(@RequestParam(required=true,value="materialId")String id) {
    	try{
    		return questionsRepo.findAll(Long.decode(id));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public void saveQuestion(@RequestBody Questions question) {
    	try{
    		questionsRepo.save(question);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{questionId}",method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable String questionId) {
    	try{
    		questionsRepo.delete(Long.decode(questionId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{questionId}", method = RequestMethod.PATCH)
    public void updateQuestion(@RequestBody Questions question) {
		try{
				questionsRepo.save(question);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //QUESTIONS END
}
