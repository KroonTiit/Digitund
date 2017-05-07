package com.digitund.questins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/QuestionsRestContoller")
public class QuestionsRestContoller {

	@Autowired 
	private QuestionsRepo questionsRepo;
	@Autowired 
	public QuestionsRestContoller(QuestionsRepo questionsRepo){
		this.questionsRepo=questionsRepo;
	}
	 //QUESTIONS
    @RequestMapping("/getAllUserQuestions")
    public List<Questions> getAllUserQuestions(@RequestParam(value="material_id")long material_id) {
		List<Questions> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(material_id);
    		responce = questionsRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveQuestion")
    public void saveQuestion(@RequestParam(value="material_id")Long material_id,
    							 @RequestParam(value="ordernr")Long order_nr,
    							 @RequestParam(value="question")String question) {
    	try{
    		Questions Question = new Questions(material_id, order_nr, question);
    		questionsRepo.save(Question);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam(value="id")long id,
    		@RequestParam(value="material_id")long material_id) {
    	Questions responce=null;
    	try{
    		responce= new Questions(id, material_id);
    		questionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/updateQuestion")
    public void updateQuestion(@RequestParam(value="id")Long id,
    						@RequestParam(value="material_id")Long material_id,
    						@RequestParam(value="ordernr")Long order_nr,
    						@RequestParam(value="question")String question) {
		try{
			Questions newQuestion= new Questions(id, material_id, order_nr, question);
			Questions updateQuestion = questionsRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newQuestion.getMaterial_id()).equals(null)){
				updateQuestion.setMaterial_id(material_id);
				change=true;
			}
			if(!((Long)newQuestion.getOrder_nr()).equals(null)){
				updateQuestion.setOrder_nr(order_nr);
				change=true;
			}
			if(!((String)newQuestion.getTekst()).equals(null)){
				updateQuestion.setTekst(question);
				change=true;
			}
			if(change){
				questionsRepo.save(updateQuestion);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //QUESTIONS END
}
