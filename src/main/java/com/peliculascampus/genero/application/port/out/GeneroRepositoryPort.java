package com.peliculascampus.genero.application.port.out;

import java.util.List;

import com.peliculascampus.genero.domain.Genero;


public interface GeneroRepositoryPort {
    Genero save(Genero genero);

    Genero findById(int id);

    List<Genero> findAll();

    void update(Genero genero);

    void delete(int id);
}
