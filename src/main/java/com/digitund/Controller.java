package com.digitund;

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

import com.digitund.lesson.Lesson;
import com.digitund.lesson.LessonRepo;
import com.digitund.tekst.Tekst;
import com.digitund.tekst.TekstRepo;


@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired 
	private TekstRepo tekstRepo;
	@Autowired 
	private LessonRepo lessonRepo;
	
	@RequestMapping("/")
    public String showAllUsers(){
		
    	return "Olen Ärkvel... Päriselt! Miks sa ei usu mind?";
    }
	
	@RequestMapping("/getAllUserLessons")
	
	public JsonObject getUsersLessons(@RequestParam(value="Id")Long Id){
		List<Lesson> findByCreator = lessonRepo.findByCreator(Id);
		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//		JsonArrayBuilder arrayMaterials = Json.createArrayBuilder();
		
		for (Lesson lesson : findByCreator) {
//			List<Tekst> allUserTekst = tekstRepo.findByLessonId((Long)lesson.getId());
//			for (Tekst tekst : allUserTekst) {
////				System.out.println("w: "+tekst.getLesson_id()+" t: "+tekst.getOrder_nr()+" r: "+tekst.getTekst());
//				JsonObjectBuilder tekstBuilder = Json.createObjectBuilder();
//				JsonObject lessonJson =tekstBuilder.add("lessonId", tekst.getLesson_id())
//						.add("order_nr", tekst.getOrder_nr())
//						.add("tekst", tekst.getTekst()).build();
//				arrayMaterials.add(lessonJson);
////			}
			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
			JsonObject lessonJson = lessonbuilder.add("id", lesson.getId())
			.add("name",lesson.getName())
			.add("userId", lesson.getCreatorId())
//			.add("startDate", (JsonValue) lesson.getStart_date())
//			.add("EndDate",(JsonValue) lesson.getEnd_date())
//			.add("materials", arrayMaterials)
			.build();
			arrayBuilder.add(lessonJson);
		}
		JsonObject build = rootBuilder.add("Lessons", arrayBuilder).build();
		return build;
	}
}
