package com.digitund.lesson;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LessonRestController")
public class LessonRestController {
	
	@Autowired 
	private LessonRepo lessonRepo;
	@Autowired 
	public  LessonRestController (LessonRepo lessonRepo){
		this.lessonRepo=lessonRepo;
	}
	 //LESSON 
    @RequestMapping("/getAllUserLessons")
    public  Object getAllUserLessons(@RequestParam(value="creator_id")long creator_id) {
    	try{ 
    		return lessonRepo.findOne(creator_id);
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
    public void setCreateUserLessons( 
    		@RequestParam(value="startDate")Timestamp startDate, 
    		@RequestParam(value="created")Timestamp created,
    		@RequestParam(value="creatorId")long creatorId,
    		@RequestParam(value="lessonPermaLink")String lessonPermaLink,
    		@RequestParam(value="name")String name) {
    	try{
    		//lessonPermaLink selle loomine tuleb väljaselgitada
    		Lesson lesson = new Lesson(startDate, created, creatorId, lessonPermaLink, name);
    		lessonRepo.save(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
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
