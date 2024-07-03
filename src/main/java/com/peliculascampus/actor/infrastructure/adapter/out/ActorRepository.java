package com.peliculascampus.actor.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.peliculascampus.actor.application.port.out.ActorRepositoryPort;
import com.peliculascampus.actor.domain.Actor;

public class ActorRepository implements ActorRepositoryPort {
    private  String url;
    private String username;
    private String password;
    
    @Override
    public Actor save(Actor actor) {
        String query =  "INSERT INTO actor VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public Actor findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Actor> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void update(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
