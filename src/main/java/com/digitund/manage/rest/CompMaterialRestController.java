package com.digitund.manage.rest;

import java.util.List;

import com.digitund.manage.model.CompMaterial;
import com.digitund.manage.data.CompMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comp-materials")
public class CompMaterialRestController {
	@Autowired 
	private CompMaterialRepo compMaterialRepo;
	@Autowired 
	public CompMaterialRestController (CompMaterialRepo compMaterialRepo){
		this.compMaterialRepo=compMaterialRepo;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{lessonId}", method = RequestMethod.GET)
	 public CompMaterial getMaterial(@PathVariable String lessonId) {
		try {
			return compMaterialRepo.findOne(Long.decode(lessonId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
	 public List<CompMaterial> getAllMaterial(@RequestParam(required=true,value="lessonId") String lessonId) {
		try {
			return compMaterialRepo.findByLessonId(Long.decode(lessonId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	//POST
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.POST)
	public CompMaterial createMaterial(@RequestBody CompMaterial compMaterial) {
		try {
			return compMaterialRepo.save(compMaterial);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	
	//DELETE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{compMaterialId}",method = RequestMethod.DELETE)
	public void deleteMaterial(@PathVariable String compMaterialId) {
		try {
			compMaterialRepo.delete(Long.decode(compMaterialId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	//UPDATE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{compMaterialId}",method = RequestMethod.PATCH)
	public String updateMaterial(@RequestBody CompMaterial compMaterial) {
    	try{
    		compMaterialRepo.save(compMaterial);
    		return "OK";
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return "not OK";
		}
    }
	
}
