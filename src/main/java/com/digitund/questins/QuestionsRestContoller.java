package com.digitund.questins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @SuppressWarnings("null")
	@RequestMapping("/getAllUserQuestions")
    public List<Questions> getAllUserQuestions(@RequestBody Questions questions) {
		List<Questions> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(questions.getMaterial_id());
    		responce = questionsRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/createQuestion")
    public void saveQuestion(@RequestBody Questions question) {
    	try{
//    		Questions Question = new Questions(materialId, orderNr, question);
    		questionsRepo.save(question);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteQuestion")
    public void deleteQuestion(@RequestBody Questions question) {
    	Questions responce=null;
    	try{
    		responce= new Questions(question.getMaterial_id());
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
