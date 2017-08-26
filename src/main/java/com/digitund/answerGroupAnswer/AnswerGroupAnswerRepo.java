package com.digitund.answerGroupAnswer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerGroupAnswerRepo extends JpaRepository<AnswerGroupAnswer, Long>{
	@Query("select s from AnswerGroupAnswer s where s.answerGroupId like ?1")
	List<AnswerGroupAnswer> findByAnswerGrouId(long answerGrouId);
}
