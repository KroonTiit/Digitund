package com.digitund.manage.data;

import com.digitund.manage.model.Question;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

  @Query("select q from Question q where q.compMaterialId like ?1 ")
  List<Question> findByCompMaterial(Long compMaterialId);

  @Query("select q.id from Question q where q.compMaterialId in ?1 ")
  List<Long> findIdsByCompMaterials(Set<Long> compMaterialId);

}
