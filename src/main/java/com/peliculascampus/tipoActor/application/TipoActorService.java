package com.peliculascampus.tipoActor.application;

import com.peliculascampus.tipoActor.domain.TipoActor;
import com.peliculascampus.tipoActor.infrastructure.TipoActorRepository;

import java.util.List;
import java.util.Optional;

public class TipoActorService {
    
    private final TipoActorRepository tipoActorRepository;

    public TipoActorService(TipoActorRepository tipoActorRepository) {
        this.tipoActorRepository = tipoActorRepository;
    }

    public  void guardarTipoActor(TipoActor tipoActor){
        this.tipoActorRepository.guardar(tipoActor);
    }

    public void actualizarTipoActor(TipoActor tipoActor){
        this.tipoActorRepository.actalizar(tipoActor);
    }

    public List<TipoActor> listarTipoActor(){
        return this.tipoActorRepository.listarTodo();
    }

    public Optional<TipoActor> buscarTipoActorPorId(int id){
        return this.tipoActorRepository.buscarPorId(id);
    }

    public void eliminarTipoActor(int id){
        this.tipoActorRepository.eliminar(id);
    }
}
