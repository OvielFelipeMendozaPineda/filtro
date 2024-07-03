package com.peliculascampus.pelicula.application;

import com.peliculascampus.actor.domain.Actor;
import com.peliculascampus.actor.infrastructure.adapter.out.ActorRepository;
import com.peliculascampus.pelicula.domain.Pelicula;
import com.peliculascampus.pelicula.infrastructure.PeliculaRepository;
import com.peliculascampus.tipoActor.domain.TipoActor;
import com.peliculascampus.tipoActor.infrastructure.TipoActorRepository;

import java.util.List;
import java.util.Optional;

public class PeliculaService {
    private final PeliculaRepository peliculaRepository;
    private final ActorRepository actorRepository;
    private final TipoActorRepository tipoActorRepository;

    public PeliculaService(PeliculaRepository peliculaRepository, TipoActorRepository tipoActorRepository) {
        this.peliculaRepository = peliculaRepository;
        this.actorRepository = new ActorRepository();
        this.tipoActorRepository =  tipoActorRepository;
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

    public void peliculaProtagonista(int idPelicula, int idActor, int idTA){
        this.peliculaRepository.peliculaactor(idPelicula, idActor, idTA);
    }

    public List<Actor> listarActores(){
        return this.actorRepository.findAll();
    }

    public Actor obtenerUnActor(int id){
        return this.actorRepository.findById(id);
    }

    public List<TipoActor> listarTipoActor(){
        return this.tipoActorRepository.listarTodo();
    }

    public Optional<TipoActor> obtenerUnTA(int id){
        return this.tipoActorRepository.buscarPorId(id);
    }
}
