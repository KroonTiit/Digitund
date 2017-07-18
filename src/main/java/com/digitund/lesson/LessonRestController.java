package com.digitund.lesson;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitund.BaseX;
import com.digitund.tekst.Tekst;
import com.digitund.tekst.TekstRepo;
import com.digitund.tekst.TekstRestController;

@RestController
@RequestMapping("/LessonRestController")
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
	@RequestMapping("/getSingleLessons")
    public JsonObject getAllUserLessons(@RequestParam(value="Id")String Id) {
    	try{
    		BaseX baseX = new BaseX();
    		BigInteger lessonId = baseX.decode(Id);
			Lesson lesson = lessonRepo.findOne(lessonId.longValue());
			
			JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
    			JsonObject lessonJson = lessonbuilder.add("id", lesson.getId())
    			.add("name",lesson.getName())
    			.add("userId", lesson.getCreatorId())
    			.build();
    			arrayBuilder.add(lessonJson);
    		JsonObject build = rootBuilder.add("Lessons", arrayBuilder).build();
    		return build;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    @RequestMapping("/getAllUserLessons")
    public JsonObject getAllUserLessons(@RequestParam(value="creatorId")long creatorId) {
    	try{
    		List<Lesson> findByCreator = lessonRepo.findByCreator(creatorId);
    		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    		for (Lesson lesson : findByCreator) {
    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
    			JsonObject lessonJson = lessonbuilder.add("id", lesson.getId())
    			.add("name",lesson.getName())
    			.add("userId", lesson.getCreatorId())
    			.build();
    			arrayBuilder.add(lessonJson);
    		}
    		JsonObject build = rootBuilder.add("Lessons", arrayBuilder).build();
    		return build;
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @RequestMapping("/deleteUserLessonsById")
    public void getDeleteUserLessons(@RequestParam(value="Id")long id,
    		@RequestParam(value="creatorId")long creatorId) {
    	try{ 
    		Lesson lesson = new Lesson(id, creatorId);
    		lessonRepo.delete(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
   
    @RequestMapping("/createUserLessons")
    public String setCreateUserLessons( 
    		@RequestBody Lesson lesson
//    		,
//    		@RequestParam(value="startDate")Timestamp startDate, 
//    		@RequestParam(value="creatorId")long creatorId,
////    		@RequestParam(value="lessonPermaLink")String lessonPermaLink,
//    		@RequestParam(value="name")String name
    		) {
    	try{
//    		Timestamp startDate = new Timestamp(System.currentTimeMillis());
    		Timestamp created = new Timestamp(System.currentTimeMillis());
//    		Lesson lesson = new Lesson(lesson.getStart_date(), created, creatorId, name);
    		Lesson savedLesson = lessonRepo.save(lesson);
    		return makeUrl(savedLesson.getId());
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    @RequestMapping("/updateUserLessons")
    public String setUpdateUserLessons(
    		@RequestBody Lesson lesson
//    		@RequestParam(value="id")long id,
//    		@RequestParam(value="name")String name
    		) {
    	try{
//    		Lesson updateLesson = lessonRepo.findOne(id);
//    		updateLesson.setName(name);
    		lessonRepo.save(lesson);
    		return "OK";
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return "not OK";
		}
    }
    //LESSON END
}
