package com.digitund.manage.rest;

import com.digitund.manage.model.UserGroupUser;
import com.digitund.manage.data.UserGroupUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/user-group-users")
public class UserGroupUserRestController {
	@Autowired 
	private UserGroupUserRepo userGroupUserRepo;
	@Autowired 
	public UserGroupUserRestController(UserGroupUserRepo UserGroupUserRepo){
		this.userGroupUserRepo = UserGroupUserRepo;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{userGroupUsersId}",method = RequestMethod.GET)
	public UserGroupUser getuserGroupUser(@PathVariable String userGroupUsersId) {
    		return userGroupUserRepo.findOne(Long.decode(userGroupUsersId));
	}
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public UserGroupUser createUserGroupUsers(@RequestBody UserGroupUser UserGroupUser){
    		return userGroupUserRepo.save(UserGroupUser);
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/deleteUserGroupUsers", method=RequestMethod.DELETE)
    public void deleteUserGroupUsers(@RequestBody UserGroupUser UserGroupUser){
		userGroupUserRepo.delete(UserGroupUser);
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{UserGroupUsersId}", method = RequestMethod.PATCH)
    public void updateUserGroup(@RequestBody UserGroupUser UserGroupUser) {
		try{
			userGroupUserRepo.save(UserGroupUser);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
}
