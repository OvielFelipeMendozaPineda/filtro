package com.peliculascampus.pelicula.adapter.out;
 
import com.peliculascampus.actor.infrastructure.adapter.in.ActorController;
import com.peliculascampus.pelicula.domain.Pelicula;
import com.peliculascampus.pelicula.infrastructure.PeliculaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PelicualOutAdapter implements PeliculaRepository {
    private final String url;
    private final String user;
    private final String password;

    public PelicualOutAdapter(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void guardar(Pelicula pelicula) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO pelicula (codinterno, nombre, duracion, sinopsis) VALUES(?,?,?,?)";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setString(1, pelicula.getCodigointerno());
                stm.setString(2, pelicula.getNombre());
                stm.setString(3, pelicula.getDuracion());
                stm.setString(4, pelicula.getSinopsis());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE  pelicula SET  codinterno = ?, nombre = ?, duracion = ?, sinopsis = ? WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setString(1, pelicula.getCodigointerno());
                stm.setString(2, pelicula.getNombre());
                stm.setString(3, pelicula.getDuracion());
                stm.setString(4, pelicula.getSinopsis());
                stm.setInt(5, pelicula.getId());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pelicula> listarTodo() {
        List<Pelicula> peliculas = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, codinterno, nombre, duracion, sinopsis FROM pelicula";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                ResultSet resultSet = stm.executeQuery();
                while (resultSet.next()){
                    Pelicula pelicula = new Pelicula(resultSet.getInt("id"), resultSet.getString("codinterno"), resultSet.getString("nombre"), resultSet.getString("duracion"), resultSet.getString("sinopsis"));
                    peliculas.add(pelicula);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return peliculas;
    }

    @Override
    public Optional<Pelicula> buscarPorId(int id) {
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id, codinterno, nombre, duracion, sinopsis FROM pelicula WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, id);
                ResultSet resultSet = stm.executeQuery();
                if (resultSet.next()){
                    Pelicula pelicula = new Pelicula(resultSet.getInt("id"), resultSet.getString("codinterno"), resultSet.getString("nombre"), resultSet.getString("duracion"), resultSet.getString("sinopsis"));
                    return Optional.of(pelicula);
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
            String query = "DELETE FROM pelicula WHERE id = ?";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, id);
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void peliculaactor(int idPelicula, int idActor, int idTipoActor){
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO peliculaprotagonista  VALUES (?,?,?)";
            try(PreparedStatement stm = conn.prepareStatement(query)){
                stm.setInt(1, idPelicula);
                stm.setInt(2, idActor);
                stm.setInt(3, idTipoActor);
                stm.executeUpdate();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
