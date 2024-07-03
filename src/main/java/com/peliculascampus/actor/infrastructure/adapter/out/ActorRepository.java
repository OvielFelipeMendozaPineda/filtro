package com.peliculascampus.actor.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.peliculascampus.actor.application.port.out.ActorRepositoryPort;
import com.peliculascampus.actor.domain.Actor;

public class ActorRepository implements ActorRepositoryPort {
    private String url;
    private String username;
    private String password;

    public ActorRepository(String url, String username, String password) {
        this.url = "jdbc:mysql://localhost:3306/peliculas";
        this.username = "campus2023";
        this.password = "campus2023";
    }

    @Override
    public Actor save(Actor actor) {
        String query = "INSERT INTO actor VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, actor.getNombre());
            preparedStatement.setInt(2, actor.getIdNacionalidad());
            preparedStatement.setInt(3, actor.getEdad());
            preparedStatement.setInt(4, actor.getIdGenero());
            preparedStatement.executeUpdate();
            return actor;
        } catch (Exception e) {
            System.out.println("Error al guardar en la base de datos.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Actor findById(int id) {
        String query = "SELECT *  FROM actor WHERE id = ?";
        Actor actor = new Actor();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resulset = statement.executeQuery(query);
            if (resulset.next()) {
                actor.setId(resulset.getInt("id"));
                actor.setNombre(resulset.getString("nombre"));
                actor.setIdNacionalidad(resulset.getInt("idnacionalidad"));
                actor.setEdad(resulset.getInt("edad"));
                actor.setIdGenero(resulset.getInt("idgenero"));
                return actor;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Actor> findAll() {
        String query = "SELECT * FROM actor";
        List<Actor> actores = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resulset = statement.executeQuery(query);
            while (resulset.next()) {
                Actor actor = new Actor();
                actor.setId(resulset.getInt("id"));
                actor.setNombre(resulset.getString("nombre"));
                actor.setIdNacionalidad(resulset.getInt("idnacionalidad"));
                actor.setEdad(resulset.getInt("edad"));
                actor.setIdGenero(resulset.getInt("idgenero"));
                actores.add(actor);
            }
            return actores;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Actor actor) {
        String query = "UPDATE actor set nombre = ?, set idnacionalidad = ?, set edad = ?, set idgenero = ? WHERE id = ? ";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, actor.getNombre());
            preparedStatement.setInt(2, actor.getIdNacionalidad());
            preparedStatement.setInt(3, actor.getEdad());
            preparedStatement.setInt(4, actor.getIdGenero());
            preparedStatement.setInt(5, actor.getId());
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
