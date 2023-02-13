package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.MedicamentoEnfermedad;
import com.software.checkhealtybackend.repository.IMedicamentoEnfermedadRepository;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicamentoEnfermedadServiceImpl implements IMedicamentoEnfermedadService {

    private IMedicamentoEnfermedadRepository medicamentoEnfermedadRepository;

    @Override
    public MedicamentoEnfermedad findById(Long aId) {
        return this.medicamentoEnfermedadRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public MedicamentoEnfermedad createMedicamentoEnfermedad(MedicamentoEnfermedad aMedicamentoEnfermedad){
        return this.medicamentoEnfermedadRepository.save(aMedicamentoEnfermedad);
    }

    @Override
    @Transactional
    public MedicamentoEnfermedad updateMedicamentoEnfermedad(MedicamentoEnfermedad aMedicamentoEnfermedad){
        return this.medicamentoEnfermedadRepository.save(aMedicamentoEnfermedad);
    }

    @Override
    @Transactional
    public void deleteMedicamentoEnfermedad(Long aId) {
        this.medicamentoEnfermedadRepository.deleteById(aId);
    }


    @Autowired
    public void setMedicamentoEnfermedadRepository(IMedicamentoEnfermedadRepository medicamentoEnfermedadRepository){
        this.medicamentoEnfermedadRepository = medicamentoEnfermedadRepository;
    }
}

