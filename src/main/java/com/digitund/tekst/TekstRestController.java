package com.digitund.tekst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TekstRestController")
public class TekstRestController {

	@Autowired 
	private TekstRepo tekstRepo;
	@Autowired 
	public TekstRestController(TekstRepo tekstRepo){
		this.tekstRepo=tekstRepo;
	}
	  //TEKST 
    @RequestMapping("/getAllUserTekst")
    public List<Tekst> getAllUserTekst(@RequestParam(value="lesson_id")long lesson_id) {
		List<Tekst> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(lesson_id);
    		responce = tekstRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveTekst")
    public void saveTekst(@RequestParam(value="lessonId")Long lesson_id,
    							 @RequestParam(value="ordernr")Long order_nr,
    							 @RequestParam(value="tekst")String tekst) {
		
    	try{
    		Tekst Tekst = new Tekst(lesson_id, order_nr, tekst);
    		tekstRepo.save(Tekst);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	
    }
    
    @RequestMapping("/deleteTekst")
    public void deleteTekst(@RequestParam(value="id")long id,
    						@RequestParam(value="lesson_id")long lesson_id) {
		Tekst responce=null;
    	try{
    		responce= new Tekst(id, lesson_id);
    		tekstRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }

    @RequestMapping("/updateTekst")
    public void updateTekst(@RequestParam(value="id")Long id,
    						@RequestParam(value="lessonid")Long lesson_id,
    						@RequestParam(value="ordernr")Long order_nr,
    						@RequestParam(value="tekst")String tekst) {
		try{
			Tekst newTekst = new Tekst(id, lesson_id, order_nr, tekst);
			Tekst updateTekst = tekstRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newTekst.getLesson_id()).equals(null)){
				updateTekst.setLesson_id(lesson_id);
				change=true;
			}
			if(!((Long)newTekst.getOrder_nr()).equals(null)){
				updateTekst.setOrder_nr(order_nr);
				change=true;
			}
			if(!((String)newTekst.getTekst()).equals(null)){
				updateTekst.setTekst(tekst);
				change=true;
			}
			if(change){
				tekstRepo.save(updateTekst);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //TEKST END
}
