package com.digitund.tekst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value="/getAllUserTekst", method=RequestMethod.POST)
    public List<Tekst> getAllUserTekst(@RequestBody Tekst tekst
//    		Param(value="lessonId")long lessonId
    		) {
		List<Tekst> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(tekst.getLesson_id());
    		responce = tekstRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping(value="/saveTekst", method=RequestMethod.POST)
    public void saveTekst(@RequestBody Tekst tekst
//    		Param(value="lessonId")Long lessonId,
//    							 @RequestParam(value="orderNr")Long orderNr,
//    							 @RequestParam(value="tekst")String tekst
    							 ) {
		
    	try{
//    		Tekst text = new Tekst(lessonId, orderNr, tekst);
    		tekstRepo.save(tekst);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	
    }
    
    @RequestMapping(value="/deleteTekst", method=RequestMethod.POST)
    public void deleteTekst(@RequestBody Tekst tekst
//    		Param(value="id")long id,
//    						@RequestParam(value="lessonId")long lessonId
    						) {
		Tekst responce=null;
    	try{
    		responce= new Tekst(tekst.getLesson_id(),responce.getOrder_nr(), tekst.getTekst());
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
