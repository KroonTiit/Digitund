package com.digitund.manage.rest;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;


import com.digitund.manage.model.Lesson;
import com.digitund.manage.data.LessonRepo;
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

	private LessonRepo lessonRepo;

	@Autowired 
	public  LessonRestController (LessonRepo lessonRepo){
		this.lessonRepo=lessonRepo;
	}
	
    public String makeUrl(Long id) {
		BaseX baseX = new BaseX();
		return baseX.encode(new BigInteger(id.toString()));
    }
    
    @RequestMapping("/basex")
    public String getconvert(@RequestParam (value="b")BigInteger base) {
    	BaseX baseX= new BaseX();
    	return baseX.encode(base);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{lessonId}", method = RequestMethod.GET)
    public Lesson getOneUserLesson(@PathVariable String lessonId) {
    	//	BaseX baseX = new BaseX();
    		//BigInteger lessonId = baseX.decode(id);
//			Lesson newLesson = lessonRepo.findOne(Long.decode(lessonId));
//			
//			JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
//    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
//    			JsonObject lessonJson = lessonbuilder.add("id", newLesson.getId())
//    			.add("name",newLesson.getName())
//    			.add("userId", newLesson.getUserId())
//    			.build();
//    			arrayBuilder.add(lessonJson);
//    		JsonObject build = rootBuilder.add("Lessons", arrayBuilder).build();
		return lessonRepo.findOne(Long.decode(lessonId));
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET)
    public List<Lesson> getAllUserLessons(@RequestParam(required=true,value="userId")String id) {
//    		List<Lesson> findByCreator = lessonRepo.findByCreator(id);
//    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//    		for (Lesson oneLesson : findByCreator) {
//    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
//    			JsonObject lessonJson = lessonbuilder.add("id", oneLesson.getId())
//    			.add("name",oneLesson.getName())
//    			.add("userId", oneLesson.getUserId())
//    			.build();
//    			arrayBuilder.add(lessonJson);
//    		}
    		//return arrayBuilder.build();
		return lessonRepo.findByCreator(id);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping (value="/{lessonId}",method = RequestMethod.DELETE)
    public void deleteUserLessons(@PathVariable String lessonId) {
		lessonRepo.delete(Long.decode(lessonId));
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public Lesson createUserLessons(@RequestBody Lesson lesson) {
//    		Timestamp startDate = new Timestamp(System.currentTimeMillis());
		Timestamp created = new Timestamp(System.currentTimeMillis());
		lesson.setStartTime(created);
//    		makeUrl(savedLesson.getId()); //kommenteerisin välja sest tahame testimiseks kasutada kümnend id-sid
		return lessonRepo.save(lesson);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{lessonId}", method = RequestMethod.PATCH)
    public String updateUserLessons(@RequestBody Lesson lesson) {
		lessonRepo.save(lesson);
		return "OK";
    }
}
