package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.User;

@Service
public interface UserService {
    User insertUser(User user);
    List<User> getAllUsers();
    void deleteUserById(long id);
    User updateEmailById(long id, String email);
    User getUserByEmail(String email);
}
