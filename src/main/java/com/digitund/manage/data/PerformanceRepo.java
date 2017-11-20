package com.digitund.manage.data;

import com.digitund.manage.model.Performance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepo extends JpaRepository<Performance, Long> {

  @Query("select s from Performance s where s.performerId like ?1 and s.lessonId = ?2")
  List<Performance> getPerformances(String performerId, Long lessonId);
}
