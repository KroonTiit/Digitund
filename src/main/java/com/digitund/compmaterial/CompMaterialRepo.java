package com.digitund.compmaterial;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompMaterialRepo extends JpaRepository<CompMaterial, Long>{

	@Query("select s from CompMaterial s where s.lessonId like ?1 ")
	List<CompMaterial> findByLessonId(long lessonId);
}
