package com.peliculascampus.genero.application.port.in;

import java.util.List;

import com.peliculascampus.genero.domain.Genero;

public interface IGeneroService {
    Genero create(Genero genero);

    List<Genero> getAll();

    Genero getById(int id);

    void update(Genero genero);

    void delete(int id);
}
