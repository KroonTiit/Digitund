package com.digitund.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value="/getAllUserVid", method=RequestMethod.POST)
    public List<Video> getAllVid(@RequestBody Video video) {
		List<Video> responce=null;
		List<Long> id=null;
    	try{
    		id.add(video.getLesson_id());
    		responce = videoRepo.findAll(id);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    	return responce;
    }
    @RequestMapping (value="/saveVid", method= RequestMethod.POST)
    public void saveVid(@RequestBody Video video
//    		Param(value="lessonId")long lessonId, 
//    						   @RequestParam(value="orderNr")long orderNr,
//    						   @RequestParam(value="videoStart")String videoStart,
//    						   @RequestParam(value="videoEnd")String videoEnd,
//    						   @RequestParam(value="videoUrl")String videoUrl
    						   ) {
//    	Video video = new Video(video.getLesson_id(), video.getOrder_nr(), video.getVideo_start(), video.getVideo_end(), videoUrl);
    	try{
    		videoRepo.save(video);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
    @RequestMapping("/deleteVid")
    public void deleteVid(@RequestParam(value="id")long id,
    		@RequestParam(value="lessonId")long lessonId) {
		Video video = new Video(id, lessonId);
		try{
			videoRepo.delete(video);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
    
    @RequestMapping("/updateVid")
    public void updateVid(@RequestParam(value="id")long id,
    					@RequestParam(value="lessonId")long lessonId, 
    					@RequestParam(value="ordernr")long orderNr,
    					@RequestParam(value="videostart")String videoStart,
    					@RequestParam(value="videoend")String videoEnd,
    					@RequestParam(value="videourl")String videoUrl) {
		try{
			Video newVid = new Video(lessonId, orderNr, videoStart, videoEnd, videoUrl);
			Video updateVideo = videoRepo.findOne(id);
			Boolean change =false;
			if(!newVid.getLesson_id().equals(null)){
				updateVideo.setLesson_id(lessonId);
				change=true;
			}
			if(!newVid.getOrder_nr().equals(null)){
				updateVideo.setOrder_nr(orderNr);
				change=true;
			}
			if(!newVid.getVideo_end().equals(null)){
				updateVideo.setVideo_end(videoEnd);
				change=true;
			}
			if(!newVid.getVideo_start().equals(null)){
				updateVideo.setVideo_start(videoStart);
				change=true;
			}
			if(!newVid.getVideo_url().equals(null)){
				updateVideo.setVideo_url(videoUrl);
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
