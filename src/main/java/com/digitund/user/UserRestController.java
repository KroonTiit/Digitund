package com.digitund.user;

import java.sql.Timestamp;
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
@RequestMapping("/api/userRestController")
public class UserRestController {
	@Autowired 
	private UserRepo userRepo;

	@Autowired
	public UserRestController(UserRepo userRepo){
		this.userRepo=userRepo;
	}
	
	// USER STUFF
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method=RequestMethod.GET)
    public boolean getUser(@PathVariable String user) {
    	Users newUser = userRepo.findOne(Long.decode(user));
    	if(newUser != null && newUser.getId()==Long.decode(user)){
    		return true;
    	} else {
    		return false;
    	}
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@RequestBody Users user){
    	try {
    		// siin tuleb mingi asi välja mõelda kuidas auth=-ist id-si salvestama hakata
//    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        	Users user = new Users(timestamp);
        	userRepo.save(user);
        	return "OK";
		} catch (Exception e) {
			return null;
		}
    	
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/showAllUsers")
    public List<Users> showAllUsers(){
    	return userRepo.findAll();
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/deleteUsers", method=RequestMethod.POST)
    public String showAllUsers(@RequestBody Users user){
    	try {
//        	Users user=null; 
//        	user =new Users(id);
    		userRepo.delete(user);
    		return "OK";
		} catch (Exception e) {
			return null;
		}
    	
    	
    }
    //USER END

}
