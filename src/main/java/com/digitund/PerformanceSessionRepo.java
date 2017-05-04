package com.digitund;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceSessionRepo extends JpaRepository<PerformanceSession, Long>{
	@Query("select s from PerformanceSession s where s.performance_id like ?1 and s.questions_id = ?2 and s.answer_options_id = ?3")
	List<PerformanceSession> getPerformanceSession(Long performance_id, Long questions_id, Long answer_options_id);
}