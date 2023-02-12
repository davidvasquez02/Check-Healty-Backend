package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Examen;
import com.software.checkhealtybackend.repository.IExamenRepository;
import com.software.checkhealtybackend.service.interfaces.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamenServiceImpl implements IExamenService {

    private IExamenRepository examenRepository;


    @Override
    public Examen findById(Long aId) {
        return this.examenRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Examen createExamen(Examen aExamen){
        return this.examenRepository.save(aExamen);
    }

    @Override
    @Transactional
    public Examen updateExamen(Examen aExamen){
        return this.examenRepository.save(aExamen);
    }

    @Override
    @Transactional
    public void deleteExamen(Long aId) {
        this.examenRepository.deleteById(aId);
    }


    @Autowired
    public void setExamenRepository(IExamenRepository examenRepository){
        this.examenRepository = examenRepository;
    }
}
