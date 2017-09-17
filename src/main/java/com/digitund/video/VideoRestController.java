package com.digitund.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/videos")
public class VideoRestController {
	@Autowired
	private VideoRepo videoRepo;
	
	@Autowired
    public VideoRestController( VideoRepo videoRepo){
		this.videoRepo=videoRepo;
	}

    //VIDEO
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{videoId}", method=RequestMethod.GET)
    public Video getVideo(@PathVariable String videoId) {
    	try{
    		return videoRepo.findOne(Long.decode(videoId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET)
    public List<Video> getAllVideos(@RequestParam(required=true,value="lessonId") String lessonId) {
    	try{
    		
    		return videoRepo.findAll(Long.decode(lessonId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping (method = RequestMethod.POST)
    public void saveVid(@RequestBody Video video) {
//    	Video video = new Video(video.getLesson_id(), video.getOrder_nr(), video.getVideo_start(), video.getVideo_end(), videoUrl);
    	try {
    		videoRepo.save(video);
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
		}
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{videoId}",method = RequestMethod.DELETE)
    public void deleteVid(@PathVariable String videoId) {
		try {
			videoRepo.delete(Long.decode(videoId));
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{videoId}", method = RequestMethod.PATCH)
    public void updateVid(@RequestBody Video video) {
		try {
				videoRepo.save(video);
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
    //VIDEO END
}
