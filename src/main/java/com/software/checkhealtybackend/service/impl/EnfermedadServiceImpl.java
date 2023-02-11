package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Enfermedad;
import com.software.checkhealtybackend.repository.IEnfermedadRepository;
import com.software.checkhealtybackend.service.interfaces.IEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnfermedadServiceImpl implements IEnfermedadService {

    private IEnfermedadRepository enfermedadRepository;


    @Override
    public Enfermedad findById(Long aId) {
        return this.enfermedadRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Enfermedad createEnfermedad(Enfermedad aEnfermedad){
        return this.enfermedadRepository.save(aEnfermedad);
    }

    @Override
    @Transactional
    public Enfermedad updateEnfermedad(Enfermedad aEnfermedad){
        return this.enfermedadRepository.save(aEnfermedad);
    }

    @Override
    @Transactional
    public void deleteEnfermedad(Long aId) {
        this.enfermedadRepository.deleteById(aId);
    }


    @Autowired
    public void setEnfermedadRepository(IEnfermedadRepository enfermedadRepository){
        this.enfermedadRepository = enfermedadRepository;
    }
}
