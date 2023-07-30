package com.example.demo.repositories;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.example.demo.models.User;

@DataMongoTest
public class TestUserRepository {

    @Autowired
    private UserRepository userRepository;

    public User newUser;
    public User userSaved;

    @BeforeEach
    public void init(){
        newUser = new User(2L,"pepito","pepito@gmail.com");
        userSaved = userRepository.insert(newUser);
    }

    @AfterEach
    public void onFinish(){
        userRepository.delete(newUser);
    }

    @Test
    public void testUserInsert(){
        //when
        
        //then
        Assertions.assertThat(userSaved.getId()).isEqualTo(2L);
        Assertions.assertThat(userSaved.getName()).isEqualTo("pepito");
        Assertions.assertThat(userSaved.getEmail()).isEqualTo("pepito@gmail.com");
    }

    @Test
    public void findUserByEmail(){
        //when
        User userFound = userRepository.findByEmail(newUser.getEmail());

        //then
        Assertions.assertThat(userFound.getEmail()).isEqualTo("pepito@gmail.com");
    }

    @Test
    public void testDeleteUser(){
        //when
        userRepository.delete(newUser);
        User userFound = userRepository.findByEmail(newUser.getEmail());

        //then
        Assertions.assertThat(userFound).isNull();
    }

}
