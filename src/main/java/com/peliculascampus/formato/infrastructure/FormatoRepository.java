package com.peliculascampus.formato.infrastructure;

import com.peliculascampus.formato.domain.Formato;

import java.util.List;
import java.util.Optional;

public interface FormatoRepository {
    void guardar(Formato formato);
    void actalizar(Formato formato);
    List<Formato> listarTodo();
    Optional<Formato> buscarPorId(int id);
    void eliminar(int id);
}
