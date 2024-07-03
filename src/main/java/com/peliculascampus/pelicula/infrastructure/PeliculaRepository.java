package com.peliculascampus.pelicula.infrastructure;

import com.peliculascampus.pelicula.domain.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaRepository {

    void guardar(Pelicula pelicula);
    void actualizar(Pelicula pelicula);
    List<Pelicula> listarTodo();
    Optional<Pelicula> buscarPorId(int id);
    void eliminar(int id);
    void peliculaactor(int idPelicula, int idActor, int idTipoActor);
}
