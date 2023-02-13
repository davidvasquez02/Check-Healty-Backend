package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.TipoFrecuencia;
import com.software.checkhealtybackend.repository.ITipoFrecuenciaRepository;
import com.software.checkhealtybackend.service.interfaces.ITipoFrecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoFrecuenciaServiceImpl implements ITipoFrecuenciaService {

    private ITipoFrecuenciaRepository tipoFrecuenciaRepository;


    @Override
    public TipoFrecuencia findById(Long aId) {
        return this.tipoFrecuenciaRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public TipoFrecuencia createTipoFrecuencia(TipoFrecuencia aTipoFrecuencia){
        return this.tipoFrecuenciaRepository.save(aTipoFrecuencia);
    }

    @Override
    @Transactional
    public TipoFrecuencia updateTipoFrecuencia(TipoFrecuencia aTipoFrecuencia){
        return this.tipoFrecuenciaRepository.save(aTipoFrecuencia);
    }

    @Override
    @Transactional
    public void deleteTipoFrecuencia(Long aId) {
        this.tipoFrecuenciaRepository.deleteById(aId);
    }


    @Autowired
    public void setTipoFrecuenciaRepository(ITipoFrecuenciaRepository tipoFrecuenciaRepository){
        this.tipoFrecuenciaRepository = tipoFrecuenciaRepository;
    }
}
