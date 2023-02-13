package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.ExamenEnfermedad;
import com.software.checkhealtybackend.repository.IExamenEnfermedadRepository;
import com.software.checkhealtybackend.service.interfaces.IExamenEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamenEnfermedadServiceImpl implements IExamenEnfermedadService {

    private IExamenEnfermedadRepository examenEnfermedadRepository;

    @Override
    public ExamenEnfermedad findById(Long aId) {
        return this.examenEnfermedadRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public ExamenEnfermedad createExamenEnfermedad(ExamenEnfermedad aExamenEnfermedad){
        return this.examenEnfermedadRepository.save(aExamenEnfermedad);
    }

    @Override
    @Transactional
    public ExamenEnfermedad updateExamenEnfermedad(ExamenEnfermedad aExamenEnfermedad){
        return this.examenEnfermedadRepository.save(aExamenEnfermedad);
    }

    @Override
    @Transactional
    public void deleteExamenEnfermedad(Long aId) {
        this.examenEnfermedadRepository.deleteById(aId);
    }


    @Autowired
    public void setExamenEnfermedadRepository(IExamenEnfermedadRepository examenEnfermedadRepository){
        this.examenEnfermedadRepository = examenEnfermedadRepository;
    }
}

