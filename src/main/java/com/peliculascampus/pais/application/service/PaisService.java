package com.peliculascampus.pais.application.service;

import java.util.List;

import com.peliculascampus.pais.application.port.in.IPaisService;
import com.peliculascampus.pais.domain.Pais;
import com.peliculascampus.pais.infrastructure.adapter.out.PaisRepository;

public class PaisService implements IPaisService{
    private PaisRepository paisRepository;
    

    public PaisService() {
        this.paisRepository = new PaisRepository();
    }

    @Override
    public Pais create(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void delete(int id) {
        paisRepository.delete(id);
        
    }

    @Override
    public List<Pais> getAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais getById(int id) {
        return paisRepository.findById(id);
    }

    @Override
    public void update(Pais pais) {
        paisRepository.update(pais);
        
    }
    
}
