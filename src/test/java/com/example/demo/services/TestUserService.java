package com.example.demo.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;


@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class TestUserService {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImp userServiceImp;

    User newUser;

    @BeforeEach
    public void setUp(){
        newUser = new User(2L, "pepito", "pepito@gmail.com");
    }

    @DisplayName("Test on insert a new data in mongo")
    @Test
    public void insertNewData(){
        //when
        when(userRepository.insert(newUser)).thenReturn(newUser);
        User userInserted = userServiceImp.insertUser(newUser);

        //then
        Assertions.assertThat(userInserted.getName()).isEqualTo("pepito");
    }

    @DisplayName("Test when update a new data in mongo")
    @Test
    public void testUpdateByEmailUserInMongo(){
        //when
        when(userRepository.findById(newUser.getId())).thenReturn(Optional.of(newUser));
        newUser.setEmail("pepitoupdate@gmail.com");
        when(userRepository.save(newUser)).thenReturn(newUser);

        User userUpdated = userServiceImp.updateEmailById(newUser.getId(), "pepitoupdate@gmail.com");
    
        //then
        Assertions.assertThat(userUpdated.getEmail()).isEqualTo("pepitoupdate@gmail.com");
    }

    @DisplayName("Given: and new user delete user by id")
    @Test
    public void testDeleteUserById(){
        //when
        when(userRepository.findById(2L)).thenReturn(Optional.of(newUser));
        doNothing().when(userRepository).deleteById(2L);

        userServiceImp.deleteUserById(2L);

        //then
        verify(userRepository, times(1)).deleteById(2L);
    }

}
