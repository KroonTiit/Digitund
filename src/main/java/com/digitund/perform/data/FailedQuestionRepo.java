package com.digitund.perform.data;

import com.digitund.perform.model.FailedQuestion;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FailedQuestionRepo extends JpaRepository<FailedQuestion, Long> {

  @Query("select fq from FailedQuestion fq where fq.performanceId like ?1 and fq.corrected = false")
  List<FailedQuestion> findUncorrectedByPerformanceId(Long performanceId);

  @Query(
      value = "select fq from FailedQuestion fq "
          + "where fq.performanceId like ?1 and fq.corrected = false "
          + "order by fq.orderNr asc limit 1",
      nativeQuery = true
  )
  Optional<FailedQuestion> findFirstUncorrectedByPerformanceId(Long performanceId);

  @Query("update FailedQuestion fq set corrected = true "
      + "where fq.performanceId like ?1 and fq.compMaterialId like ?2")
  void setCorrectedByPerformanceAndCompMaterial(Long performanceId, Long compMaterialId);
}
