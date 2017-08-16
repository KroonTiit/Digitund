package com.digitund.questions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitund.lesson.Lesson;
import com.digitund.video.Video;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Long>{
	
	@Query("select s from Questions s where s.lessonId like ?1 ")
	List<Video> findAll(Long decode);
}
