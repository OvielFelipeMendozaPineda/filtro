package com.peliculascampus.actor.application.port.in;

import java.util.List;

import com.peliculascampus.actor.domain.Actor;

public interface IActorService {
    Actor create(Actor actor);
    List<Actor> getAll();
    Actor getById(int id);
    void update(Actor actor);
    void delete(int id);
}
