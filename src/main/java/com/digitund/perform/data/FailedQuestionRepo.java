package com.digitund.perform.data;

import com.digitund.perform.model.FailedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailedQuestionRepo extends JpaRepository<FailedQuestion, Long> {

}
