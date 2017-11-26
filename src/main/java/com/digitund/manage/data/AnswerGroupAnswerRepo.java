package com.digitund.manage.data;

import com.digitund.manage.model.AnswerGroupAnswer;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerGroupAnswerRepo extends JpaRepository<AnswerGroupAnswer, Long> {

  @Query("select aga from AnswerGroupAnswer aga where aga.answerGroup.id like ?1")
  List<AnswerGroupAnswer> findByAnswerGroupId(long answerGroupId);

  @Query("select aga from AnswerGroupAnswer aga where aga.answerGroup.id in ?1")
  List<AnswerGroupAnswer> findByGroupIds(Set<Long> groupIds);

  @Query("select aga from AnswerGroupAnswer aga "
      + "inner join aga.answerGroup ag "
      + "where ag.questionId like ?1")
  List<AnswerGroupAnswer> findByQuestionId(Long questionId);
}
