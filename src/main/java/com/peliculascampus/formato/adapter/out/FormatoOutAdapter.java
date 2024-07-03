package com.peliculascampus.formato.adapter.out;

import com.peliculascampus.formato.infrastructure.FormatoRepository;
import com.peliculascampus.formato.domain.Formato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FormatoOutAdapter implements FormatoRepository {
    private final String url;
    private final String user;
    private final String password;

    public FormatoOutAdapter(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    @Override
    public void guardar(Formato formato) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO formato (descripcion) VALUES(?)";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setString(1, formato.getNombre());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actalizar(Formato formato) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  formato SET  descripcion =?  WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setString(1, formato.getNombre());
                stm.setInt(2, formato.getId());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Formato> listarTodo() {
        List<Formato> formatos = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM formato";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                ResultSet resultSet = stm.executeQuery();
                while (resultSet.next()){
                    Formato formato = new Formato(resultSet.getInt("id"), resultSet.getString("descripcion"));
                    formatos.add(formato);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return formatos;
    }

    @Override
    public Optional<Formato> buscarPorId(int id) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "SELECT  id, descripcion  FROM formato WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, id);
                ResultSet resultSet = stm.executeQuery();
                if (resultSet.next()){
                    Formato formato = new Formato(resultSet.getInt("id"), resultSet.getString("descripcion"));
                    return Optional.of(formato);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(int id) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM formato WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, id);
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
