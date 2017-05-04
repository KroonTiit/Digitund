package com.digitund;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Video {
	@Id @GeneratedValue
	private Long id;
	private Long lesson_id;
	private Long order_nr;
	private String video_start;
	private String video_end;
	private String video_url;
	
	public Video(){}
	public Video(long lesson_id){
		this.lesson_id=lesson_id;
	}
	public Video(long id,long lesson_id){
		this.id=id;
		this.lesson_id=lesson_id;
	}
	public Video(Long lesson_id, Long order_nr, String video_start, String video_end, String video_url){
		this.lesson_id=lesson_id;
		this.order_nr=order_nr;
		this.video_end=video_end;
		this.video_start=video_start;
		this.video_url=video_url;
	}
	
	public Long getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(Long lesson_id) {
		this.lesson_id = lesson_id;
	}
	public Long getOrder_nr() {
		return order_nr;
	}
	public void setOrder_nr(Long order_nr) {
		this.order_nr = order_nr;
	}
	public String getVideo_start() {
		return video_start;
	}
	public void setVideo_start(String video_start) {
		this.video_start = video_start;
	}
	public String getVideo_end() {
		return video_end;
	}
	public void setVideo_end(String video_end) {
		this.video_end = video_end;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	
	
}
