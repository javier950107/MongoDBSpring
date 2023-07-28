package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        try {
            userService.deleteUserById(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PatchMapping(value = "/update-email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable("id") long id, @RequestBody User user){
        try {
            User userUpdated = userService.updateEmailById(id, user.getEmail());
            return ResponseEntity.ok(userUpdated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping(value = "/get-user")
    public ResponseEntity<?> getUserByEmail(@RequestBody User user){
        try {
            User userFound = userService.getUserByEmail(user.getEmail());
            return ResponseEntity.ok(userFound);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    
}
