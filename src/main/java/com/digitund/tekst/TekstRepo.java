package com.digitund.tekst;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TekstRepo extends JpaRepository<Tekst, Long>{
	
	@Query("select t from Tekst t where t.lessonId= ?1")
	List<Tekst> findByLessonId(Long lessonId);
}
