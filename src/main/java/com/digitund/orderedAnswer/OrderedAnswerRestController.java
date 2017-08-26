package com.digitund.orderedAnswer;

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
@RequestMapping("/api/orderedAnswer")
public class OrderedAnswerRestController {
	@Autowired 
	private OrderedAnswerRepo orderedAnswerRepo;
	@Autowired 
	public OrderedAnswerRestController (OrderedAnswerRepo orderedAnswerRepo){
		this.orderedAnswerRepo=orderedAnswerRepo;
	}
	//GET
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{questionId}", method = RequestMethod.GET)
	 public OrderedAnswer getMaterial(@PathVariable String questionId) {
		try {
			return orderedAnswerRepo.findOne(Long.decode(questionId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
	 public List<OrderedAnswer> getAllMaterial(@RequestParam(required=true,value="orderedAnswer") String questionId) {
		try {
			return orderedAnswerRepo.findByQuestionId(Long.decode(questionId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	//POST
		@CrossOrigin(origins = "http://localhost:3000")
		@RequestMapping(method = RequestMethod.POST)
		public OrderedAnswer createMaterial(@RequestBody OrderedAnswer orderedAnswer) {
			try {
				return orderedAnswerRepo.save(orderedAnswer);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				return null;
			}
		}
		//DELETE
		@CrossOrigin(origins = "http://localhost:3000")
		@RequestMapping (value="/{materialId}",method = RequestMethod.DELETE)
		public void deleteMaterial(@PathVariable String materialId) {
			try {
				orderedAnswerRepo.delete(Long.decode(materialId));
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
		//UPDATE
		@CrossOrigin(origins = "http://localhost:3000")
		@RequestMapping (value="/{materialId}",method = RequestMethod.PATCH)
		public String updateMaterial(@RequestBody OrderedAnswer orderedAnswer) {
	    	try{
	    		orderedAnswerRepo.save(orderedAnswer);
	    		return "OK";
	    	} catch (Exception e) {
	    		System.out.println( e.getStackTrace());
	    		return "not OK";
			}
	    }
		
}
