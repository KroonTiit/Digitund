package com.digitund.manage.rest;

import com.digitund.manage.data.CompMaterialRepo;
import com.digitund.manage.model.CompMaterial;
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
@RequestMapping("/api/comp-materials")
public class CompMaterialRestController {

  private CompMaterialRepo compMaterialRepo;

  @Autowired
  public CompMaterialRestController(CompMaterialRepo compMaterialRepo) {
    this.compMaterialRepo = compMaterialRepo;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{compMaterialId}", method = RequestMethod.GET)
  public CompMaterial getMaterial(@PathVariable Long compMaterialId) {
    return compMaterialRepo.findOne(compMaterialId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public List<CompMaterial> getAllMaterial(
      @RequestParam(required = true, value = "lessonId") Long lessonId) {
    return compMaterialRepo.findByLessonId(lessonId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public CompMaterial createMaterial(@RequestBody CompMaterial compMaterial) {
    return compMaterialRepo.save(compMaterial);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{compMaterialId}", method = RequestMethod.DELETE)
  public void deleteMaterial(@PathVariable Long compMaterialId) {
    compMaterialRepo.delete(compMaterialId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/{compMaterialId}", method = RequestMethod.PATCH)
  public String updateMaterial(@RequestBody CompMaterial compMaterial) {
    compMaterialRepo.save(compMaterial);
    return "OK";
  }

}
