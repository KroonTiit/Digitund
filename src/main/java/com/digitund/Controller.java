package com.digitund;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitund.manage.model.Lesson;
import com.digitund.manage.data.LessonRepo;


@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired 
	private LessonRepo lessonRepo;

	@RequestMapping("/")
    public String showAllUsers(){
		
    	return "Olen Ärkvel... Päriselt! Miks sa ei usu mind?";
    }
	
	@RequestMapping("/getAllUserLessons")
	
	public JsonObject getUsersLessons(@RequestParam(value="Id")String Id){
		List<Lesson> findByCreator = lessonRepo.findByCreator(Id);
		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//		JsonArrayBuilder arrayMaterials = Json.createArrayBuilder();
		
		for (Lesson lesson : findByCreator) {
//			List<TextMaterial> allUserTekst = tekstRepo.findByLessonId((Long)lesson.getId());
//			for (TextMaterial textmaterial : allUserTekst) {
////				System.out.println("w: "+textmaterial.getLesson_id()+" t: "+textmaterial.getOrder_nr()+" r: "+textmaterial.getText());
//				JsonObjectBuilder tekstBuilder = Json.createObjectBuilder();
//				JsonObject lessonJson =tekstBuilder.add("lessonId", textmaterial.getLesson_id())
//						.add("order_nr", textmaterial.getOrder_nr())
//						.add("textmaterial", textmaterial.getText()).build();
//				arrayMaterials.add(lessonJson);
////			}
			JsonObjectBuilder lessonbuilder = Json.createObjectBuilder();
			JsonObject lessonJson = lessonbuilder.add("id", lesson.getId())
			.add("name",lesson.getName())
			.add("userId", lesson.getUserId())
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
