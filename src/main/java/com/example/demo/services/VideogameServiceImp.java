package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Videogame;
import com.example.demo.repositories.VideogameRepository;


@Service
public class VideogameServiceImp implements VideogameService{

    @Autowired
    private VideogameRepository videogameRepository;

    @Override
    public Videogame insertVideogame(Videogame videogame) {
        return videogameRepository.insertVideogame(videogame);
    }

    @Override
    public List<Videogame> getAllVideogames() {
        return videogameRepository.getAllVideogames();
    }

    @Override
    public Videogame updateVideogame(Videogame videogame) {
        Videogame videogameFound = videogameRepository.findById(videogame.getId());

        if (!videogameFound.equals(null)){
            String idUpdated = videogameRepository.updateVideogame(videogameFound);
            return videogameRepository.findById(Integer.valueOf(idUpdated));
        }

        return null;
    }

    @Override
    public void deleteVideogameById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVideogameById'");
    }
    
}
