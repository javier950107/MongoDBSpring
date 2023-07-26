package com.example.demo.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    
    @Id
    private Long id;

    private String name;
    private String email;
}
