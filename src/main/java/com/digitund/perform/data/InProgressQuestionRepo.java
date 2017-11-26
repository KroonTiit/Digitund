package com.digitund.perform.data;

import com.digitund.perform.model.InProgressQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InProgressQuestionRepo extends JpaRepository<InProgressQuestion, Long> {

  List<InProgressQuestion> findByPerformanceId(Long performanceId);

  @Query("delete from InProgressQuestion ipq where ipq.performanceId like ?1")
  void deleteByPerformanceId(Long performanceId);
}
