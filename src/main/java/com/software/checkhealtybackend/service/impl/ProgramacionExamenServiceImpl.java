package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.ProgramacionExamen;
import com.software.checkhealtybackend.repository.IProgramacionExamenRepository;
import com.software.checkhealtybackend.service.interfaces.IProgramacionExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramacionExamenServiceImpl implements IProgramacionExamenService {

    private IProgramacionExamenRepository programacionExamenRepository;


    @Override
    public ProgramacionExamen findById(Long aId) {
        return this.programacionExamenRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public ProgramacionExamen createProgramacionExamen(ProgramacionExamen aProgramacionExamen){
        return this.programacionExamenRepository.save(aProgramacionExamen);
    }

    @Override
    @Transactional
    public ProgramacionExamen updateProgramacionExamen(ProgramacionExamen aProgramacionExamen){
        return this.programacionExamenRepository.save(aProgramacionExamen);
    }

    @Override
    @Transactional
    public void deleteProgramacionExamen(Long aId) {
        this.programacionExamenRepository.deleteById(aId);
    }


    @Autowired
    public void setProgramacionExamenRepository(IProgramacionExamenRepository programacionExamenRepository){
        this.programacionExamenRepository = programacionExamenRepository;
    }
}
