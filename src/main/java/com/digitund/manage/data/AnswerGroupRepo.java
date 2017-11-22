package com.digitund.manage.data;

import com.digitund.manage.model.AnswerGroup;
import com.digitund.manage.model.AnswerGroupAnswer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerGroupRepo extends JpaRepository<AnswerGroup, Long> {

  @Query("select s from AnswerGroup s where s.questionId like ?1 ")
  List<AnswerGroup> findByQuestionId(Long questionId);

}
