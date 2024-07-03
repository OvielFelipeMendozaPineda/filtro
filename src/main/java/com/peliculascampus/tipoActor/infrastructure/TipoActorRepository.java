package com.peliculascampus.tipoActor.infrastructure;

import com.peliculascampus.tipoActor.domain.TipoActor;

import java.util.List;
import java.util.Optional;

public interface TipoActorRepository {
    void guardar(TipoActor tipoActor);
    void actalizar(TipoActor tipoActor);
    List<TipoActor> listarTodo();
    Optional<TipoActor> buscarPorId(int id);
    void eliminar(int id);
}
