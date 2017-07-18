package com.digitund.lesson;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitund.performanceSession.PerformanceSession;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long>{

	@Query("select s from Lesson s where s.creatorId like ?1 ")
	List<Lesson> findByCreator(Long creatorId);
}