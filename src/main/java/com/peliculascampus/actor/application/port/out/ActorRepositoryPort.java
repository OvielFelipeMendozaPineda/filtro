package com.peliculascampus.actor.application.port.out;

import java.util.List;

import com.peliculascampus.actor.domain.Actor;

/**
 * ActorRepositoryPort
 */
public interface ActorRepositoryPort {

    Actor save (Actor actor);
    Actor findById (int id);
    List <Actor> findAll();
    void update(int id);
    void delete(int id);
}