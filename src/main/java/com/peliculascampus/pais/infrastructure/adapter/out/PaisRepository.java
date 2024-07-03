package com.peliculascampus.pais.infrastructure.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.peliculascampus.Helpers.Credentials;
import com.peliculascampus.pais.application.port.out.PaisRepositoryPort;
import com.peliculascampus.pais.domain.Pais;

public class PaisRepository implements PaisRepositoryPort {
    private String url;
    private String username;
    private String password;

    public PaisRepository() {
        this.url = Credentials.url;
        this.username = Credentials.username;
        this.password = Credentials.password;
    }

    @Override
    public Pais save(Pais pais) {
        String query = "INSERT INTO pais VALUES (null, ?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pais.getDescription());
            preparedStatement.executeUpdate();
            return pais;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Pais findById(int id) {
        String query = "SELECT * FROM pais WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resulset = preparedStatement.executeQuery();
            if (resulset.next()) {
                Pais pais = new Pais();
                pais.setId(resulset.getInt("id"));
                pais.setDescription(resulset.getString("descripcion"));
                return pais;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pais> findAll() {
        String query = "SELECT * FROM pais";
        List<Pais> paises = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resulset = statement.executeQuery(query);
            while (resulset.next()) {
                Pais pais = new Pais();
                pais.setId(resulset.getInt("id"));
                pais.setDescription(resulset.getString("descripcion"));
                paises.add(pais);

            }
            return paises;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Pais pais) {
        String query = "UPDATE pais set descripcion = ? WHERE id = ? ";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pais.getDescription());
            preparedStatement.setInt(2, pais.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM pais WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
