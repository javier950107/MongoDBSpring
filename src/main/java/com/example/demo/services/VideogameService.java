package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Videogame;

@Service
public interface VideogameService {
    Videogame insertVideogame(Videogame videogame);
    List<Videogame> getAllVideogames();
    Videogame updateVideogame(Videogame videogame);
    void deleteVideogameById(int id);
}
