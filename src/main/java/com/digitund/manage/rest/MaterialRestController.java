package com.digitund.manage.rest;

import com.digitund.manage.data.MaterialRepo;
import com.digitund.manage.model.Material;
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
@RequestMapping("/api/materials")
public class MaterialRestController {

  private MaterialRepo materialRepo;

  @Autowired
  public MaterialRestController(MaterialRepo materialRepo) {
    this.materialRepo = materialRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.GET)
  public Material getMaterial(@PathVariable Long materialId) {
    return materialRepo.findOne(materialId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public List<Material> getByCompMaterial(
      @RequestParam(required = true, value = "compMaterialId") Long compMaterialId) {
    return materialRepo.findByCompId(compMaterialId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public Material createMaterial(@RequestBody Material material) {
    return materialRepo.save(material);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.DELETE)
  public void deleteMaterial(@PathVariable Long materialId) {
    materialRepo.delete(materialId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{materialId}", method = RequestMethod.PATCH)
  public String updateMaterial(@RequestBody Material material) {
    materialRepo.save(material);
    return "OK";
  }

}
