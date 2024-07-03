package com.peliculascampus.genero.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.peliculascampus.Helpers.Credentials;
import com.peliculascampus.genero.application.port.out.GeneroRepositoryPort;
import com.peliculascampus.genero.domain.Genero;

public class GeneroRepository implements GeneroRepositoryPort {

    private String url;
    private String username;
    private String password;

    public GeneroRepository() {
        this.url = Credentials.url;
        this.username = Credentials.username;
        this.password = Credentials.password;
    }

    @Override
    public Genero save(Genero genero) {
        String query = "INSERT INTO genero VALUES (null, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genero.getDescripcion());
            preparedStatement.executeUpdate();
            return genero;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Genero findById(int id) {
        String query = "SELECT * FROM genero WHERE id = ?;";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resulset = preparedStatement.executeQuery();
            if (resulset.next()) {
                Genero genero = new Genero();
                genero.setId(resulset.getInt("id"));
                genero.setDescripcion(resulset.getString("descripcion"));
                return genero;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genero> findAll() {
        List<Genero> generos = new ArrayList<>();
        String query = "SELECT * FROM genero";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resulset = statement.executeQuery(query);
            while (resulset.next()) {
                Genero genero = new Genero();
                genero.setId(resulset.getInt("id"));
                genero.setDescripcion(resulset.getString("descripcion"));
                generos.add(genero);

            }
            return generos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Genero genero) {
        String query = "UPDATE genero set descripcion = ? WHERE id = ? ";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genero.getDescripcion());
            preparedStatement.setInt(2, genero.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM genero WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
