package com.digitund.user;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserRestController")
public class UserRestController {
	@Autowired 
	private UserRepo userRepo;

	@Autowired
	public UserRestController(UserRepo userRepo){
		this.userRepo=userRepo;
	}
	
	// USER STUFF
    @RequestMapping(value="/getUser", method=RequestMethod.POST)
    public boolean getUser(@RequestBody Users user) {
    	Users newUser = userRepo.findOne(user.getId());
    	if(newUser != null && newUser.getId()==user.getId()){
    		return true;
    	} else {
    		return false;
    	}
    }
    @RequestMapping("/createUser")
    public String createUser(){
    	try {
    		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        	Users user = new Users(timestamp);
        	userRepo.save(user);
        	return "OK";
		} catch (Exception e) {
			return null;
		}
    	
    }
   
    @RequestMapping("/showAllUsers")
    public List<Users> showAllUsers(){
    	return userRepo.findAll();
    }
    
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
