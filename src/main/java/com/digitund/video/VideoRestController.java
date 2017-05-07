package com.digitund.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/VideoRestController")
public class VideoRestController {
	@Autowired
	private VideoRepo videoRepo;
	
	@Autowired
    public VideoRestController( VideoRepo videoRepo){
		this.videoRepo=videoRepo;
	}

    //VIDEO
    @RequestMapping("/getAllUserVid")
    public List<Video> getAllVid(@RequestParam(value="lesson_id")long lesson_id) {
		List<Video> responce=null;
		List<Long> id=null;
    	try{
    		id.add(lesson_id);
    		responce = videoRepo.findAll(id);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    @RequestMapping("/saveVid")
    public void saveVid(@RequestParam(value="lessonId")long lesson_id, 
    						   @RequestParam(value="ordernr")long order_nr,
    						   @RequestParam(value="videostart")String video_start,
    						   @RequestParam(value="videoend")String video_end,
    						   @RequestParam(value="videourl")String video_url) {
    	Video video = new Video(lesson_id, order_nr, video_start, video_end, video_url);
    	try{
    		videoRepo.save(video);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    @RequestMapping("/deleteVid")
    public void deleteVid(@RequestParam(value="id")long id,
    		@RequestParam(value="lesson_id")long lesson_id) {
		Video video = new Video(id, lesson_id);
		try{
			videoRepo.delete(video);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    
    @RequestMapping("/updateVid")
    public void updateVid(@RequestParam(value="id")long id,
    					@RequestParam(value="lessonId")long lesson_id, 
    					@RequestParam(value="ordernr")long order_nr,
    					@RequestParam(value="videostart")String video_start,
    					@RequestParam(value="videoend")String video_end,
    					@RequestParam(value="videourl")String video_url) {
		try{
			Video newVid = new Video(lesson_id, order_nr, video_start, video_end, video_url);
			Video updateVideo = videoRepo.findOne(id);
			Boolean change =false;
			if(!newVid.getLesson_id().equals(null)){
				updateVideo.setLesson_id(lesson_id);
				change=true;
			}
			if(!newVid.getOrder_nr().equals(null)){
				updateVideo.setOrder_nr(order_nr);
				change=true;
			}
			if(!newVid.getVideo_end().equals(null)){
				updateVideo.setVideo_end(video_end);
				change=true;
			}
			if(!newVid.getVideo_start().equals(null)){
				updateVideo.setVideo_start(video_start);
				change=true;
			}
			if(!newVid.getVideo_url().equals(null)){
				updateVideo.setVideo_url(video_url);
				change=true;
			}
			if(change){
				videoRepo.save(updateVideo);
				change=false;
			}
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    //VIDEO END
}
