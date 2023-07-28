package com.example.demo.repositories;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Videogame;

@Repository
public class VideogameRepositoryImp implements VideogameRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Videogame insertVideogame(Videogame videogame) {
        return mongoTemplate.insert(videogame);
    }

    @Override
    public List<Videogame> getAllVideogames() {
        return mongoTemplate.findAll(Videogame.class);
    }

    @Override
    public void deleteVideogameById(int id) {
        Query query = new Query().addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Videogame.class);
    }

    @Override
    public Videogame findById(int id) {
        return mongoTemplate.findById(id, Videogame.class);
    }

    @Override
    public Videogame updateVideogame(Videogame videogame) {
        Query query = new Query().addCriteria(Criteria.where("id").is(videogame.getId()));
        Update updateDefinition = new Update()
            .set("name", videogame.getName()).set("description", videogame.getDescription());
        
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Videogame videogameUpdated = mongoTemplate.findAndModify(query, updateDefinition, options, Videogame.class);
        return videogameUpdated;
    }
    
}
