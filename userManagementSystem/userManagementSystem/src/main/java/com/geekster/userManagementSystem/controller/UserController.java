package com.geekster.userManagementSystem.controller;

import com.geekster.userManagementSystem.model.User;
import com.geekster.userManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value="/getAllUser")
    public List<User> getAllUser(){
      return  userService.getAllUser();

    }
    @PostMapping(value="/addUser")
    public String addUser(@Valid @RequestBody User user){
        return userService.addMyUser(user);

    }
    @RequestMapping(value="/getUser/{userId}",method=RequestMethod.GET)
    public User getUserById(@PathVariable  String userId){
        return userService.getUserBasedOnId(userId);

    }
    @DeleteMapping(value="/deleteUserById/{id}")
    public String deleteUserById(@PathVariable String id){
        return userService.removeUserById(id);
    }
      @PutMapping(value="/upadateUserNameById/{id}/{userName}")
    public String updateUserNameById(@PathVariable String id, @PathVariable String userName){
        return userService.updateUserNameById(id,userName);
      }

}
