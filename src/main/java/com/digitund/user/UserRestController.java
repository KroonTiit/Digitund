package com.digitund.user;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/getuser")
    public boolean getUser(@RequestParam(value="id")long id) {
    	Users user = userRepo.findOne(id);
    	if(user != null && user.getId()==id){
    		return true;
    	} else {
    		return false;
    	}
    }
    @RequestMapping("/createuser")
    public void createUser(){
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	Users user = new Users(timestamp);
    	userRepo.save(user);
    }
   
    @RequestMapping("/showAllUsers")
    public List<Users> showAllUsers(){
    	return userRepo.findAll();
    }
    
    @RequestMapping("/deleteUsers")
    public String showAllUsers(@RequestParam(value="id")long id){
    	Users user=null; 
    	user =new Users(id);
    	userRepo.delete(user);
		return "OK";
    }
    //USER END

}
