package com.digitund.manage.data;

import com.digitund.manage.model.AnswerOption;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerOptionRepo extends JpaRepository<AnswerOption, Long> {

  @Query("select s from AnswerOption s where s.questionId like ?1")
  List<AnswerOption> findByQuestionId(long questionId);
}