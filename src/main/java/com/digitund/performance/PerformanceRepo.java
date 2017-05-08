package com.digitund.performance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepo extends JpaRepository<Performance, Long>{
	@Query("select s from Performance s where s.performer_id like ?1 and s.lesson_id = ?2")
	List<Performance> getPerformance(Long performerId, Long lessonId);
}
