package com.digitund.manage.data;

import com.digitund.manage.model.OrderedAnswer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedAnswerRepo extends JpaRepository<OrderedAnswer, Long> {

  @Query("select s from OrderedAnswer s where s.questionId like ?1 ")
  OrderedAnswer findByQuestionId(long questionId);
 
}
