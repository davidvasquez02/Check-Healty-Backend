package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.MedicamentoUsuario;
import com.software.checkhealtybackend.repository.IMedicamentoUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicamentoUsuarioImpl implements IMedicamentoUsuarioService {

    private IMedicamentoUsuarioRepository medicamentoUsuarioRepository;

    @Override
    public List<MedicamentoUsuario> findById(Long aId) {
        return this.medicamentoUsuarioRepository.findByIdEnfermedadUsuario(aId);
    }

    @Override
    @Transactional
    public MedicamentoUsuario createMedicamentoUsuario(MedicamentoUsuario aMedicamentoUsuario){
        return this.medicamentoUsuarioRepository.save(aMedicamentoUsuario);
    }

    @Override
    @Transactional
    public MedicamentoUsuario updateMedicamentoUsuario(MedicamentoUsuario aMedicamentoUsuario){
        return this.medicamentoUsuarioRepository.save(aMedicamentoUsuario);
    }

    @Override
    @Transactional
    public void deleteMedicamentoUsuario(Long aId) {
        this.medicamentoUsuarioRepository.deleteById(aId);
    }


    @Autowired
    public void setMedicamentoUsuarioRepository(IMedicamentoUsuarioRepository medicamentoUsuarioRepository){
        this.medicamentoUsuarioRepository = medicamentoUsuarioRepository;
    }
}

