package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.insert(user);   
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }

    @Override
    public User updateEmailById(long id, String email) {
        Optional<User> userFound = userRepository.findById(id);

        if(userFound.isPresent()){
            userFound.get().setEmail(email);
            userRepository.save(userFound.get());

            return userFound.get();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
