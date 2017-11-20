package com.digitund.userGroupUsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/user-group-users")
public class UserGroupUsersRestController {
	@Autowired 
	private  UserGroupUsersRepo UserGroupUsersRepo;
	@Autowired 
	public UserGroupUsersRestController(UserGroupUsersRepo UserGroupUsersRepo){
		this.UserGroupUsersRepo=UserGroupUsersRepo;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{userGroupUsersId}",method = RequestMethod.GET)
	public UserGroupUsers getuserGroupUser(@PathVariable String userGroupUsersId) {
    		return UserGroupUsersRepo.findOne(Long.decode(userGroupUsersId));
	}
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST)
    public UserGroupUsers createUserGroupUsers(@RequestBody UserGroupUsers UserGroupUsers){
    		return UserGroupUsersRepo.save(UserGroupUsers);
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/deleteUserGroupUsers", method=RequestMethod.DELETE)
    public void deleteUserGroupUsers(@RequestBody UserGroupUsers UserGroupUsers){
		UserGroupUsersRepo.delete(UserGroupUsers);
    }
	@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/{UserGroupUsersId}", method = RequestMethod.PATCH)
    public void updateUserGroup(@RequestBody UserGroupUsers UserGroupUsers) {
		try{
			UserGroupUsersRepo.save(UserGroupUsers);
		} catch (Exception e) {
			System.out.println( e.getStackTrace());
		}
	}
}
