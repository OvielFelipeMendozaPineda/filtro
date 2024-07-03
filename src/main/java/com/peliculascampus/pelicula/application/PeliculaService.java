package com.peliculascampus.pelicula.application;

import com.peliculascampus.pelicula.domain.Pelicula;
import com.peliculascampus.pelicula.infrastructure.PeliculaRepository;

import java.util.List;
import java.util.Optional;

public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public void guardarPelicula(Pelicula pelicula){
        this.peliculaRepository.guardar(pelicula);
    }

    public void actualizarPelicua(Pelicula pelicula){
        this.peliculaRepository.actualizar(pelicula);
    }

    public List<Pelicula> listarPeliculas(){
        return this.peliculaRepository.listarTodo();
    }

    public Optional<Pelicula> buscarPeliculaPorId(int id){
        return this.peliculaRepository.buscarPorId(id);
    }

    public void eliminarPelicula(int id){
        this.peliculaRepository.eliminar(id);
    }
}
