package com.peliculascampus.genero.application.service;

import java.util.List;

import com.peliculascampus.genero.application.port.in.IGeneroService;
import com.peliculascampus.genero.domain.Genero;
import com.peliculascampus.genero.infrastructure.adapter.out.GeneroRepository;

public class GeneroService implements IGeneroService {
    private GeneroRepository generoRepository;

    public GeneroService() {
        this.generoRepository = new GeneroRepository() ;
    }

    @Override
    public Genero create(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    @Override
    public Genero getById(int id) {
        return generoRepository.findById(id);
    }

    @Override
    public void update(Genero genero) {
        generoRepository.update(genero);
    }

    @Override
    public void delete(int id) {
        generoRepository.delete(id);
    }
    
}
