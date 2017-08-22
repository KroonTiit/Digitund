package com.digitund.lesson;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitund.BaseX;


@RestController
@RequestMapping("/api/lessons")
public class LessonRestController {

	@Autowired 
	private LessonRepo lessonRepo;
	@Autowired 
	public  LessonRestController (LessonRepo lessonRepo){
		this.lessonRepo=lessonRepo;
	}
	
    public String makeUrl(Long id) {
    	try{
    		BaseX baseX = new BaseX();
    		String lesson = baseX.encode(new BigInteger(id.toString()));
    		return lesson;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @RequestMapping("/basex")
    public String getconvert(@RequestParam (value="b")BigInteger base) {
    	BaseX baseX= new BaseX();
    	return baseX.encode(base);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{lessonId}", method = RequestMethod.GET)
    public JsonObject getOneUserLesson(@PathVariable String lessonId) {
    	try{
    	//	BaseX baseX = new BaseX();
    		//BigInteger lessonId = baseX.decode(id);
			Lesson newLesson = lessonRepo.findOne(Long.decode(lessonId));
			
			JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
    			JsonObject lessonJson = lessonbuilder.add("id", newLesson.getId())
    			.add("name",newLesson.getName())
    			.add("userId", newLesson.getCreatorId())
    			.build();
    			arrayBuilder.add(lessonJson);
    		JsonObject build = rootBuilder.add("Lessons", arrayBuilder).build();
    		return build;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @CrossOrigin(origins ="http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    public JsonArray getAllUserLessons(@RequestParam(required=true,value="userId")String id) {
    	try{
    		List<Lesson> findByCreator = lessonRepo.findByCreator(Long.decode(id));
    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    		for (Lesson oneLesson : findByCreator) {
    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
    			JsonObject lessonJson = lessonbuilder.add("id", oneLesson.getId())
    			.add("name",oneLesson.getName())
    			.add("userId", oneLesson.getCreatorId())
    			.build();
    			arrayBuilder.add(lessonJson);
    		}
    		return arrayBuilder.build();
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @CrossOrigin(origins ="http://localhost:3000")
    @RequestMapping (value="/{lessonId}",method = RequestMethod.DELETE)
    public void deleteUserLessons(@PathVariable String lessonId) {
    	try{ 
    		lessonRepo.delete(Long.decode(lessonId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @CrossOrigin(origins ="http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public long createUserLessons( 
    		@RequestBody Lesson lesson
    		) {
    	try{
//    		Timestamp startDate = new Timestamp(System.currentTimeMillis());
    		Timestamp created = new Timestamp(System.currentTimeMillis());
    		lesson.setStart_date(created);
    		Lesson savedLesson = lessonRepo.save(lesson);
//    		makeUrl(savedLesson.getId()); //kommenteerisin välja sest tahame testimiseks kasutada kümnend id-sid
    		return savedLesson.getId();
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return 0;
		}
    }
    
    @CrossOrigin(origins ="http://localhost:3000")
    @RequestMapping(value="/{lessonId}", method = RequestMethod.PATCH)
    public String updateUserLessons(@RequestBody Lesson lesson) {
    	try{
    		lessonRepo.save(lesson);
    		return "OK";
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return "not OK";
		}
    }
    //LESSON END
}
