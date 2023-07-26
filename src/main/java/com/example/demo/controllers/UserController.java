package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;


    @GetMapping(value = "/all")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertUser(@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.insertUser(user));   
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
