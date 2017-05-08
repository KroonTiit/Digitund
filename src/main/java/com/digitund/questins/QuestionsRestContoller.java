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
    public List<Questions> getAllUserQuestions(@RequestParam(value="materialId")long materialId) {
		List<Questions> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(materialId);
    		responce = questionsRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveQuestion")
    public void saveQuestion(@RequestParam(value="materialId")Long materialId,
    							 @RequestParam(value="orderNr")Long orderNr,
    							 @RequestParam(value="question")String question) {
    	try{
    		Questions Question = new Questions(materialId, orderNr, question);
    		questionsRepo.save(Question);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam(value="id")long id,
    		@RequestParam(value="material_id")long materialId) {
    	Questions responce=null;
    	try{
    		responce= new Questions(id, materialId);
    		questionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/updateQuestion")
    public void updateQuestion(@RequestParam(value="id")Long id,
    						@RequestParam(value="materialId")Long materialId,
    						@RequestParam(value="orderNr")Long orderNr,
    						@RequestParam(value="question")String question) {
		try{
			Questions newQuestion= new Questions(id, materialId, orderNr, question);
			Questions updateQuestion = questionsRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newQuestion.getMaterial_id()).equals(null)){
				updateQuestion.setMaterial_id(materialId);
				change=true;
			}
			if(!((Long)newQuestion.getOrder_nr()).equals(null)){
				updateQuestion.setOrder_nr(orderNr);
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
