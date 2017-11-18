package com.digitund.manage.rest;

import com.digitund.manage.model.UserGroup;
import com.digitund.manage.data.UserGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/user-groups")
public class UserGroupRestController {
	@Autowired 
	private com.digitund.manage.data.UserGroupRepo UserGroupRepo;
	@Autowired 
	public UserGroupRestController(UserGroupRepo UserGroupRepo){
		this.UserGroupRepo=UserGroupRepo;
	}
	
	//USER_GROUP
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{userId}",method = RequestMethod.GET)
    public UserGroup getUserGroup(@PathVariable String userId) {
    	try{
    		return UserGroupRepo.findOne(Long.decode(userId));
    	} catch (Exception e) {
    		System.out.println( e.getStackTrace());
    		return null;
		}
    	
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public UserGroup createUserGroup(@RequestBody UserGroup UserGroup){
    		return UserGroupRepo.save(UserGroup);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/deleteUsers", method=RequestMethod.DELETE)
    public void deleteUserGroup(@RequestBody UserGroup UserGroup){
    		UserGroupRepo.delete(UserGroup);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{userGroupId}", method = RequestMethod.PATCH)
    public void updateUserGroup(@RequestBody UserGroup UserGroup) {
		try{
			UserGroupRepo.save(UserGroup);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
	//USER_GROUP_END
}
