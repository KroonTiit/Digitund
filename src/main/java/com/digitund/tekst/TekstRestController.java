package com.digitund.tekst;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitund.lesson.Lesson;

@RestController
@RequestMapping("/api/tekstRestController")
public class TekstRestController {

	@Autowired 
	private TekstRepo tekstRepo;
	@Autowired 
	public TekstRestController(TekstRepo tekstRepo){
		this.tekstRepo=tekstRepo;
	}
	
	  //TEKST 
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{lessonId}",method = RequestMethod.GET)
    public Tekst getText(@PathVariable String lessonId) {
    	try{
    		return tekstRepo.findOne(Long.decode(lessonId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    public List<Tekst> getAllTexts(@RequestParam(required=true,value="lessonId")String lessonId) {
    	try{
    		return tekstRepo.findByLessonId(Long.decode(lessonId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.POST)
    public void saveTekst(@RequestBody Tekst tekst) {
    	try{
    		tekstRepo.save(tekst);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}	
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{tekstId}",method = RequestMethod.DELETE)
    public void deleteTekst(@PathVariable String tekstId) {
    	try{
    		tekstRepo.delete(Long.decode(tekstId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{tekstId}", method = RequestMethod.PATCH)
    public void updateTekst(@RequestBody Tekst tekst) {
		try{
				tekstRepo.save(tekst);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //TEKST END
}
