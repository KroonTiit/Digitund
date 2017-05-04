package com.digitund;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired 
	private AnswerOptionsRepo answerOptionsRepo;
	private LessonRepo lessonRepo;
	private PerformanceRepo performanceRepo;
	private PerformanceSessionRepo performanceSessionRepo;
	private QuestionsRepo questionsRepo;
	private TekstRepo tekstRepo;
	private UserRepo userRepo;
	private VideoRepo videoRepo;
	
	
    @Autowired
    public Controller( AnswerOptionsRepo answerOptionsRepo, LessonRepo lessonRepo, PerformanceRepo performanceRepo, PerformanceSessionRepo performanceSessionRepo,
    		QuestionsRepo questionsRepo, TekstRepo tekstRepo, UserRepo userRepo, VideoRepo videoRepo){
    	
    	this.answerOptionsRepo=answerOptionsRepo;
    	this.lessonRepo=lessonRepo;
    	this.performanceRepo=performanceRepo;
    	this.performanceSessionRepo=performanceSessionRepo;
    	this.questionsRepo=questionsRepo;
    	this.tekstRepo=tekstRepo;
    	this.userRepo=userRepo;
    	this.videoRepo=videoRepo;
    }
    // USER STUFF
    @RequestMapping("/getuser")
    public boolean getUser(@RequestParam(value="id")long id) {
    	Users user = userRepo.findOne(id);
    	if(user != null && user.getId()==id){
    		return true;
    	} else {
    		return false;
    	}
    }
    @RequestMapping("/createuser")
    public void createUser(){
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	Users user = new Users(timestamp);
    	userRepo.save(user);
    }
   
    @RequestMapping("/showAllUsers")
    public List<Users> showAllUsers(){
    	return userRepo.findAll();
    }
    
    @RequestMapping("/deleteUsers")
    public String showAllUsers(@RequestParam(value="id")long id){
    	Users user=null; 
    	user =new Users(id);
    	userRepo.delete(user);
		return "OK";
    }
    //USER END
    

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
    
    //VIDEO
    @RequestMapping("/getAllUserVid")
    public List<Video> getAllVid(@RequestParam(value="lesson_id")long lesson_id) {
		List<Video> responce=null;
		List<Long> id=null;
    	try{
    		id.add(lesson_id);
    		responce = videoRepo.findAll(id);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    @RequestMapping("/saveVid")
    public void saveVid(@RequestParam(value="lessonId")long lesson_id, 
    						   @RequestParam(value="ordernr")long order_nr,
    						   @RequestParam(value="videostart")String video_start,
    						   @RequestParam(value="videoend")String video_end,
    						   @RequestParam(value="videourl")String video_url) {
    	Video video = new Video(lesson_id, order_nr, video_start, video_end, video_url);
    	try{
    		videoRepo.save(video);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    @RequestMapping("/deleteVid")
    public void deleteVid(@RequestParam(value="id")long id,
    		@RequestParam(value="lesson_id")long lesson_id) {
		Video video = new Video(id, lesson_id);
		try{
			videoRepo.delete(video);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    
    @RequestMapping("/updateVid")
    public void updateVid(@RequestParam(value="id")long id,
    					@RequestParam(value="lessonId")long lesson_id, 
    					@RequestParam(value="ordernr")long order_nr,
    					@RequestParam(value="videostart")String video_start,
    					@RequestParam(value="videoend")String video_end,
    					@RequestParam(value="videourl")String video_url) {
		try{
			Video newVid = new Video(lesson_id, order_nr, video_start, video_end, video_url);
			Video updateVideo = videoRepo.findOne(id);
			Boolean change =false;
			if(!newVid.getLesson_id().equals(null)){
				updateVideo.setLesson_id(lesson_id);
				change=true;
			}
			if(!newVid.getOrder_nr().equals(null)){
				updateVideo.setOrder_nr(order_nr);
				change=true;
			}
			if(!newVid.getVideo_end().equals(null)){
				updateVideo.setVideo_end(video_end);
				change=true;
			}
			if(!newVid.getVideo_start().equals(null)){
				updateVideo.setVideo_start(video_start);
				change=true;
			}
			if(!newVid.getVideo_url().equals(null)){
				updateVideo.setVideo_url(video_url);
				change=true;
			}
			if(change){
				videoRepo.save(updateVideo);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //VIDEO END
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
    //QUESTIONS
    @RequestMapping("/getAllUserQuestions")
    public List<Questions> getAllUserQuestions(@RequestParam(value="material_id")long material_id) {
		List<Questions> responce=null;
		List<Long> lesson=null;
    	try{
    		lesson.add(material_id);
    		responce = questionsRepo.findAll(lesson);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveQuestion")
    public void saveQuestion(@RequestParam(value="material_id")Long material_id,
    							 @RequestParam(value="ordernr")Long order_nr,
    							 @RequestParam(value="question")String question) {
    	try{
    		Questions Question = new Questions(material_id, order_nr, question);
    		questionsRepo.save(Question);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam(value="id")long id,
    		@RequestParam(value="material_id")long material_id) {
    	Questions responce=null;
    	try{
    		responce= new Questions(id, material_id);
    		questionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/updateQuestion")
    public void updateQuestion(@RequestParam(value="id")Long id,
    						@RequestParam(value="material_id")Long material_id,
    						@RequestParam(value="ordernr")Long order_nr,
    						@RequestParam(value="question")String question) {
		try{
			Questions newQuestion= new Questions(id, material_id, order_nr, question);
			Questions updateQuestion = questionsRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newQuestion.getMaterial_id()).equals(null)){
				updateQuestion.setMaterial_id(material_id);
				change=true;
			}
			if(!((Long)newQuestion.getOrder_nr()).equals(null)){
				updateQuestion.setOrder_nr(order_nr);
				change=true;
			}
			if(!((String)newQuestion.getTekst()).equals(null)){
				updateQuestion.setTekst(question);
				change=true;
			}
			if(change){
				questionsRepo.save(updateQuestion);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //QUESTIONS END
    //ANSWERS
    @RequestMapping("/getAllAnswerOptions")
    public List<AnswerOptions> getAllQuestionsAnswers(@RequestParam(value="question_id")long question_id) {
		List<AnswerOptions> responce=null;
		List<Long> answer=null;
    	try{
    		answer.add(question_id);
    		responce = answerOptionsRepo.findAll(answer);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    
    @RequestMapping("/saveAnswerOption")
    public void saveAnswerOption(@RequestParam(value="question_id")Long question_id,
    							 @RequestParam(value="tekst")String tekst,
    							 @RequestParam(value="correct")boolean correct) {
    	try{
    		AnswerOptions answerOption = new AnswerOptions(question_id, correct, tekst);
    		answerOptionsRepo.save(answerOption);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/deleteAnswerOption")
    public void deleteAnswerOption(@RequestParam(value="id")long id,
    		@RequestParam(value="question_id")long question_id) {
    	AnswerOptions responce=null;
    	try{
    		responce= new AnswerOptions(id, question_id);
    		answerOptionsRepo.delete(responce);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    
    @RequestMapping("/updateAnswerOption")
    public void updateAnswerOption(@RequestParam(value="id")Long id,
    						@RequestParam(value="question_id")Long question_id,
    						@RequestParam(value="tekst")String tekst,
							 @RequestParam(value="correct")boolean correct) {
		try{
			AnswerOptions newAnswer= new AnswerOptions(id, question_id, correct, tekst);
			AnswerOptions updateAnswer = answerOptionsRepo.findOne(id);
			Boolean change =false;
			if(!((Long)newAnswer.getQuestion_id()).equals(null)){
				updateAnswer.setQuestion_id(question_id);
				change=true;
			}
			if(!((Boolean)newAnswer.isCorrect()).equals(null)){
				updateAnswer.setCorrect(correct);
				change=true;
			}
			if(!((String)newAnswer.getTekst()).equals(null)){
				updateAnswer.setTekst(tekst);
				change=true;
			}
			if(change){
				answerOptionsRepo.save(updateAnswer);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //ANSWERS END
    //PERFORMANCE
    @RequestMapping("/startSession")
    public Performance startSession(@RequestParam(value="performer_id")long performer_id,
    						@RequestParam(value="lesson_id")long lesson_id){
    	Performance per =null;
    	try{
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    		Performance session = new Performance(performer_id, lesson_id, timestamp);
    		per = performanceRepo.save(session);
    		
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
		return per;
    }
    @RequestMapping("/getSession")
    public List<Performance> getSession(@RequestParam(value="performer_id")Long performer_id,
    						@RequestParam(value="lesson_id")Long lesson_id){
    	List<Performance> responce=null;
    	try{
    		Performance session = new Performance(performer_id, lesson_id);
    		
    		responce=performanceRepo.getPerformance(performer_id, lesson_id);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    //PERFORMANCE END
    //PERFORMANCE SESSION
    @RequestMapping("/savePerformanceSession")
    public PerformanceSession createPerformanceSession(@RequestParam(value="performance_id")long performance_id,
		    						@RequestParam(value="question_id")long question_id,
		    						@RequestParam(value="answer_option_id")long answer_option_id){
    	PerformanceSession per= null;
    	try{
    		PerformanceSession performanceSession = new PerformanceSession(performance_id, question_id, answer_option_id);
    		per = performanceSessionRepo.save(performanceSession);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return per;
    }
    @RequestMapping("/getPerformanceSession")
    public List<PerformanceSession> getPerformanceSession(@RequestParam(value="performance_id")long performance_id,
									@RequestParam(value="question_id")long question_id,
									@RequestParam(value="answer_option_id")long answer_option_id){
    	List<PerformanceSession> per =null;
    	try{
    		per = performanceSessionRepo.getPerformanceSession(performance_id, question_id, answer_option_id);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
    	return per;
	}
  //PERFORMANCE SESSION END
}
