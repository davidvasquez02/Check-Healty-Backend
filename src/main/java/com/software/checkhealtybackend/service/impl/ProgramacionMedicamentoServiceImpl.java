package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.ProgramacionMedicamento;
import com.software.checkhealtybackend.repository.IProgramacionMedicamentoRepository;
import com.software.checkhealtybackend.service.interfaces.IProgramacionMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramacionMedicamentoServiceImpl implements IProgramacionMedicamentoService {

    private IProgramacionMedicamentoRepository programacionMedicamentoRepository;


    @Override
    public ProgramacionMedicamento findById(Long aId) {
        return this.programacionMedicamentoRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public ProgramacionMedicamento createProgramacionMedicamento(ProgramacionMedicamento aProgramacionMedicamento){
        return this.programacionMedicamentoRepository.save(aProgramacionMedicamento);
    }

    @Override
    @Transactional
    public ProgramacionMedicamento updateProgramacionMedicamento(ProgramacionMedicamento aProgramacionMedicamento){
        return this.programacionMedicamentoRepository.save(aProgramacionMedicamento);
    }

    @Override
    @Transactional
    public void deleteProgramacionMedicamento(Long aId) {
        this.programacionMedicamentoRepository.deleteById(aId);
    }


    @Autowired
    public void setProgramacionMedicamentoRepository(IProgramacionMedicamentoRepository programacionMedicamentoRepository){
        this.programacionMedicamentoRepository = programacionMedicamentoRepository;
    }
}
