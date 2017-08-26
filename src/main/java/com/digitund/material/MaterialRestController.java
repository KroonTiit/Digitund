package com.digitund.material;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/material")
public class MaterialRestController {
	@Autowired 
	private MaterialRepo materialRepo;
	@Autowired 
	public MaterialRestController (MaterialRepo materialRepo){
		this.materialRepo=materialRepo;
	}
	//MATERIAL
	//GET
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/{materialId}", method = RequestMethod.GET)
	 public Material getMaterial(@PathVariable String materialId) {
		try {
			return materialRepo.findOne(Long.decode(materialId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET)
	 public List<Material> getAllMaterial(@RequestParam(required=true,value="compMaterialId") String compMaterialId) {
		try {
			return materialRepo.findByCompId(Long.decode(compMaterialId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	//POST
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.POST)
	public Material createMaterial(@RequestBody Material material) {
		try {
			return materialRepo.save(material);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	//DELETE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{materialId}",method = RequestMethod.DELETE)
	public void deleteMaterial(@PathVariable String materialId) {
		try {
			materialRepo.delete(Long.decode(materialId));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	//UPDATE
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping (value="/{materialId}",method = RequestMethod.PATCH)
	public String updateMaterial(@RequestBody Material material) {
    	try{
    		materialRepo.save(material);
    		return "OK";
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return "not OK";
		}
    }
	
}
