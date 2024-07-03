package com.peliculascampus.actor.application.service;

import java.util.List;

import com.peliculascampus.actor.application.port.in.IActorService;
import com.peliculascampus.actor.domain.Actor;
import com.peliculascampus.actor.infrastructure.adapter.out.ActorRepository;

public class ActorService  implements IActorService{
    private ActorRepository actorRepository;

    public ActorService( ) {
        this.actorRepository = new ActorRepository();
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getById(int id) {
        return actorRepository.findById(id);
    }

    @Override
    public void update(Actor actor) {
        actorRepository.update(actor);
    }

    @Override
    public void delete(int id) {
        actorRepository.delete(id);
    }
    
}
