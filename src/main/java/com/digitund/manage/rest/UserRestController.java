package com.digitund.manage.rest;

import com.digitund.manage.data.UserRepo;
import com.digitund.manage.model.User;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

  private UserRepo userRepo;

  @Autowired
  public UserRestController(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  // USER STUFF
  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.GET)
  public boolean getUser(@PathVariable Long userId) {
    User newUser = userRepo.findOne(userId);
    return newUser != null && newUser.getId().equals(userId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(method = RequestMethod.POST)
  public String createUser(@RequestBody User user) {
    try {
      // siin tuleb mingi asi välja mõelda kuidas auth0-ist id-si salvestama hakata
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      user.setStartDate(timestamp);
      userRepo.save(user);
      return "OK";
    } catch (Exception e) {
      return null;
    }

  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping("/showAllUsers")
  public List<User> showAllUsers() {
    return userRepo.findAll();
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(value = "/deleteUsers", method = RequestMethod.DELETE)
  public String deleteUser(@RequestBody User user) {
    try {
      userRepo.delete(user);
      return "OK";
    } catch (Exception e) {
      return null;
    }


  }
  //USER END

}
