package com.userapplication.user.application.controller;

import com.userapplication.user.application.service.UserService;
import com.userapplication.user.application.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable  long id){

        return userService.getById(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id){

        userService.deleteById(id);
    }

    @GetMapping("/user/{id}/age")
    public int getUserAge(@PathVariable  long id){
//        throw new RuntimeException("dummy");
        return userService.getById(id).getUserAge();
    }




}
