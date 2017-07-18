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
    public List<Tekst> getAllUserTekst(@RequestParam(value="lessonId")long lessonId) {
		List<Tekst> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(lessonId);
    		responce = tekstRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveTekst")
    public void saveTekst(@RequestParam(value="lessonId")Long lessonId,
    							 @RequestParam(value="orderNr")Long orderNr,
    							 @RequestParam(value="tekst")String tekst) {
		
    	try{
    		Tekst text = new Tekst(lessonId, orderNr, tekst);
    		tekstRepo.save(text);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	
    }
    
    @RequestMapping("/deleteTekst")
    public void deleteTekst(@RequestParam(value="id")long id,
    						@RequestParam(value="lessonId")long lessonId) {
		Tekst responce=null;
    	try{
    		responce= new Tekst(id, lessonId);
    		tekstRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }

    @RequestMapping("/updateTekst")
    public void updateTekst(@RequestParam(value="id")Long id,
    						@RequestParam(value="lessonId")Long lessonId,
    						@RequestParam(value="orderNr")Long orderNr,
    						@RequestParam(value="tekst")String tekst) {
		try{
			Tekst newTekst = new Tekst(id, lessonId, orderNr, tekst);
			Tekst updateTekst = tekstRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newTekst.getLesson_id()).equals(null)){
				updateTekst.setLesson_id(lessonId);
				change=true;
			}
			if(!((Long)newTekst.getOrder_nr()).equals(null)){
				updateTekst.setOrder_nr(orderNr);
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
