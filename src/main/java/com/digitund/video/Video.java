package com.digitund.video;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Video {
	@Id @GeneratedValue
	private Long id;
	private Long lessonId;
	private Long orderNr;
	private String videoStart;
	private String videoEnd;
	private String videoUrl;
	
	public Video(){}
	public Video(long lessonId){
		this.lessonId=lessonId;
	}
	public Video(long id,long lessonId){
		this.id=id;
		this.lessonId=lessonId;
	}
	public Video(Long lessonId, Long orderNr, String videoStart, String videoEnd, String videoUrl){
		this.lessonId=lessonId;
		this.orderNr=orderNr;
		this.videoEnd=videoEnd;
		this.videoStart=videoStart;
		this.videoUrl=videoUrl;
	}
	
	public Long getLesson_id() {
		return lessonId;
	}
	public void setLesson_id(Long lessonId) {
		this.lessonId = lessonId;
	}
	public Long getOrder_nr() {
		return orderNr;
	}
	public void setOrder_nr(Long orderNr) {
		this.orderNr = orderNr;
	}
	public String getVideo_start() {
		return videoStart;
	}
	public void setVideo_start(String videoStart) {
		this.videoStart = videoStart;
	}
	public String getVideo_end() {
		return videoEnd;
	}
	public void setVideo_end(String videoEnd) {
		this.videoEnd = videoEnd;
	}
	public String getVideo_url() {
		return videoUrl;
	}
	public void setVideo_url(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}
