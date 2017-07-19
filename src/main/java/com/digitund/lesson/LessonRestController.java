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
import org.springframework.web.bind.annotation.RestController;

import com.digitund.BaseX;

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
    public JsonObject getOneUserLesson(@RequestBody Lesson lesson) {
    	try{
    		BaseX baseX = new BaseX();
    		BigInteger lessonId = baseX.decode(Long.toString(lesson.getId()));
			Lesson newLesson = lessonRepo.findOne(lessonId.longValue());
			
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
    @RequestMapping("/getAllUserLessons")
    public JsonObject getAllUserLessons(@RequestBody Lesson lesson) {
    	try{
    		List<Lesson> findByCreator = lessonRepo.findByCreator(lesson.getCreatorId());
    		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
    		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
    		for (Lesson oneLesson : findByCreator) {
    			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
    			JsonObject lessonJson = lessonbuilder.add("id", oneLesson.getId())
    			.add("name",oneLesson.getName())
    			.add("userId", oneLesson.getCreatorId())
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
    public void getDeleteUserLessons(@RequestBody Lesson lesson) {
    	try{ 
//    		Lesson deletingLesson = new Lesson(lesson.getId(), lesson.getCreatorId());
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
    		lesson.setStart_date(created);
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
