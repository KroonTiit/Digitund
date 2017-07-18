package com.digitund.lesson;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@Autowired 
//	private TekstRepo tekstRepo;
	@Autowired 
	private LessonRepo lessonRepo;
//	
	@Autowired 
	public  LessonRestController (LessonRepo lessonRepo){
		this.lessonRepo=lessonRepo;
	}
//	
	public JsonValue getMaterials(){
		
		return null;
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
    public Object getAllUserLessons(@RequestParam(value="l")String Id) {
    	try{
    		BaseX baseX = new BaseX();
    		BigInteger lesson = baseX.decode(Id);
    		return lessonRepo.findOne(lesson.longValue());
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    @RequestMapping("/getAllUserLessons")
    public Object getAllUserLessons(@RequestParam(value="creatorId")long creatorId) {
    	try{
    		return lessonRepo.findOne(creatorId);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    
    @RequestMapping("/deleteUserLessonsById")
    public void getDeleteUserLessons(@RequestParam(value="id")long id,
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
    		@RequestParam(value="startDate")Timestamp startDate, 
    		@RequestParam(value="creatorId")long creatorId,
//    		@RequestParam(value="lessonPermaLink")String lessonPermaLink,
    		@RequestParam(value="name")String name) {
    	try{
//    		Timestamp startDate = new Timestamp(System.currentTimeMillis());
    		Timestamp created = new Timestamp(System.currentTimeMillis());
    		Lesson lesson = new Lesson(startDate, created, creatorId, name);
    		Lesson savedLesson = lessonRepo.save(lesson);
    		return makeUrl(savedLesson.getId());
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    }
    @RequestMapping("/updateUserLessons")
    public void setUpdateUserLessons(
    		@RequestParam(value="id")long id,
    		@RequestParam(value="name")String name) {
    	try{
    		Lesson updateLesson = lessonRepo.findOne(id);
    		updateLesson.setName(name);
    		lessonRepo.save(updateLesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    //LESSON END

}
