package com.peliculascampus.formato.application;

import com.peliculascampus.formato.infrastructure.FormatoRepository;
import com.peliculascampus.formato.domain.Formato;

import java.util.List;
import java.util.Optional;

public class FormatoService {
    
    private final FormatoRepository formatoRepository;


    public FormatoService(FormatoRepository formatoRepository) {
        this.formatoRepository = formatoRepository;
    }

    public void guardarFormato(Formato formato){
        this.formatoRepository.guardar(formato);
    }

    public void actualizarFormato(Formato formato){
        this.formatoRepository.actalizar(formato);
    }

    public List<Formato> listarFormatos(){
        return this.formatoRepository.listarTodo();
    }

    public Optional<Formato> buscarFormatoPorId(int id){
        return this.formatoRepository.buscarPorId(id);
    }

    public void eliminarFormato(int id){
        this.formatoRepository.eliminar(id);
    }
}
