package com.digitund.video;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepo extends JpaRepository<Video, Long>{

	@Query("select s from Video s where s.lessonId like ?1 ")
	List<Video> findAll(Long decode);

	
}
