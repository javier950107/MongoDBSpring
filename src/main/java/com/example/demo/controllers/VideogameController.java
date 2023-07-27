package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Videogame;
import com.example.demo.services.VideogameService;

@RestController
public class VideogameController {

    @Autowired
    private VideogameService videogameService;
    
    @PostMapping(value = "/insert-videogame")
    public ResponseEntity<?> insertVideogame(@RequestBody Videogame videogame){
        try {
            return ResponseEntity.ok(videogameService.insertVideogame(videogame));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping(value = "/get-videogames")
    public List<Videogame> getVideogames(){
        return videogameService.getAllVideogames(); 
    }

    @PostMapping(value = "/update-videogame")
    public ResponseEntity<?> updateVideogames(@RequestBody Videogame videogame){
        try {
            Videogame videogameUpdated = videogameService.updateVideogame(videogame);
            return ResponseEntity.ok(videogameUpdated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
