package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Medicamento;
import com.software.checkhealtybackend.repository.IMedicamentoRepository;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {
    private IMedicamentoRepository medicamentoRepository;

    @Override
    public Medicamento findById(Long aId) {
        return this.medicamentoRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Medicamento createMedicamento(Medicamento aMedicamento){
        return this.medicamentoRepository.save(aMedicamento);
    }

    @Override
    @Transactional
    public Medicamento updateMedicamento(Medicamento aMedicamento){
        return this.medicamentoRepository.save(aMedicamento);
    }

    @Override
    @Transactional
    public void deleteMedicamento(Long aId) {
        this.medicamentoRepository.deleteById(aId);
    }

    //Lista de medicamentos by user
    @Override
    @Transactional
    public List<Medicamento> findAllByUser(Long aUser){
        return this.medicamentoRepository.allByUser(aUser);
    }


    @Autowired
    public void setMedicamentoRepository(IMedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }
}
