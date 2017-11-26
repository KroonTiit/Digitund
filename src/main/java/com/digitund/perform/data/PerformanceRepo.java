package com.digitund.perform.data;

import com.digitund.perform.model.Performance;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepo extends JpaRepository<Performance, Long> {

  @Query("select p from Performance p where p.performerId like ?1 and p.lessonId = ?2")
  List<Performance> getPerformances(String performerId, Long lessonId);

  @Query("select p from Performance p "
      + "where p.performerId like ?1 "
      + "and p.lessonId = ?2 "
      + "and p.status = 'IN_PROGRESS'")
  Optional<Performance> findInProgressByPerformerAndLesson(String performerId, Long lessonId);
}
