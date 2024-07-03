package com.peliculascampus.tipoActor.adapter.out;

import com.peliculascampus.tipoActor.domain.TipoActor;
import com.peliculascampus.tipoActor.infrastructure.TipoActorRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TipoActorOutRepository implements TipoActorRepository {
    private final String url;
    private final String user;
    private final String password;

    public TipoActorOutRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void guardar(TipoActor tipoActor) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO tipoactor (descripcion) VALUES(?)";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setString(1, tipoActor.getDescripcion());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actalizar(TipoActor tipoActor) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  tipoactor SET  descripcion = ?  WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setString(1, tipoActor.getDescripcion());
                stm.setInt(2, tipoActor.getId());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TipoActor> listarTodo() {
        List<TipoActor> tipoActors = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM tipoactor";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                ResultSet resultSet = stm.executeQuery();
                while (resultSet.next()){
                    TipoActor tipoActor = new TipoActor(resultSet.getInt("id"), resultSet.getString("descripcion"));
                    tipoActors.add(tipoActor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tipoActors;
    }

    @Override
    public Optional<TipoActor> buscarPorId(int id) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, descripcion FROM tipoactor WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, id);
                ResultSet resultSet = stm.executeQuery();
                if (resultSet.next()){
                    TipoActor tipoActor = new TipoActor(resultSet.getInt("id"), resultSet.getString("descripcion"));
                    return Optional.of(tipoActor);
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
            String query = "DELETE FROM tipoActor WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, id);
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
