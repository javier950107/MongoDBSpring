package com.example.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Videogame;

@Repository
public interface VideogameRepository {
    Videogame insertVideogame(Videogame videogame);
    List<Videogame> getAllVideogames();
    Videogame findById(int id);
    String updateVideogame(Videogame videogame);
    void deleteVideogameById(int id);
}
