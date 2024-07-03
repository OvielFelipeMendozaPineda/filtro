package com.peliculascampus.pais.application.port.out;

import java.util.List;

import com.peliculascampus.pais.domain.Pais;


public interface PaisRepositoryPort {
    Pais save(Pais pais);

    Pais findById(int id);

    List<Pais> findAll();

    void update(Pais pais);

    void delete(int id);
}
