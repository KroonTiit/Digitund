package com.digitund.answerGroup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitund.answerGroupAnswer.AnswerGroupAnswer;

@Repository
public interface AnswerGroupRepo extends JpaRepository<AnswerGroup, Long>{
	@Query("select s from AnswerGroup s where s.questionId like ?1 ")
	AnswerGroup findByQuestionId(long questionId);
	
	@Query("select s from AnswerGroupAnswer s where s.answerGroupId like ?1 ")
	List<AnswerGroupAnswer> findAnswersById(long answerGroupId);
}
