package com.peliculascampus.pais.application.port.in;

import java.util.List;

import com.peliculascampus.pais.domain.Pais;


public interface IPaisService {
    Pais create(Pais pais);

    List<Pais> getAll();

    Pais getById(int id);

    void update(Pais pais);

    void delete(int id);
}
