package com.peliculascampus.actor.application.port.out;

import java.util.List;

import com.peliculascampus.actor.domain.Actor;
import com.peliculascampus.pelicula.domain.Pelicula;

/**
 * ActorRepositoryPort
 */
public interface ActorRepositoryPort {

    Actor save (Actor actor);
    Actor findById (int id);
    List <Actor> findAll();
    void update(Actor actor);
    void delete(int id);

    Actor findByPelicula(Pelicula pelicula);
}