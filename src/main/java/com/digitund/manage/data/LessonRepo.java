package com.digitund.manage.data;

import java.util.List;

import com.digitund.manage.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long>{

	@Query("select s from Lesson s where s.userId like ?1 ")
	List<Lesson> findByCreator(String userId);
}