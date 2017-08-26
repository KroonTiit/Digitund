package com.digitund.answerGroup;

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
@RequestMapping("/api/answerGroup")
public class AnswerGroupRestController {
	
	@Autowired 
	private AnswerGroupRepo answerGroupRepo;
	@Autowired 
	public AnswerGroupRestController (AnswerGroupRepo answerGroupRepo){
		this.answerGroupRepo=answerGroupRepo;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{answerGroupId}", method = RequestMethod.GET)
	 public AnswerGroup getMaterial(@PathVariable String materialId) {
		try {
			return answerGroupRepo.findOne(Long.decode(materialId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
	 public List<AnswerGroup> getAllMaterial(@RequestParam(required=true,value="answerGroup") String answerGroup) {
		try {
			return answerGroupRepo.findByQuestionId(Long.decode(answerGroup));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	//POST
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.POST)
	public AnswerGroup createMaterial(@RequestBody AnswerGroup answerGroup) {
		try {
			return answerGroupRepo.save(answerGroup);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	//DELETE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{materialId}",method = RequestMethod.DELETE)
	public void deleteMaterial(@PathVariable String answerGroup) {
		try {
			answerGroupRepo.delete(Long.decode(answerGroup));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	//UPDATE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{materialId}",method = RequestMethod.PATCH)
	public String updateMaterial(@RequestBody AnswerGroup answerGroup) {
    	try{
    		answerGroupRepo.save(answerGroup);
    		return "OK";
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return "not OK";
		}
    }
	
}
