package com.digitund.answers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerOptionsRepo extends JpaRepository<AnswerOptions, Long>{
	@Query("select s from answerOptions s where s.userId like ?1 ")
	List<AnswerOptions> findByQuestionId(Long questionId);
}