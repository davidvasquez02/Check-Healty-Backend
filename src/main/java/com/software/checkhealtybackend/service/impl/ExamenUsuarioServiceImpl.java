package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.ExamenUsuario;
import com.software.checkhealtybackend.repository.IExamenUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IExamenUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamenUsuarioServiceImpl implements IExamenUsuarioService {

    private IExamenUsuarioRepository examenUsuarioRepository;

    @Override
    public List<ExamenUsuario> findById(Long aId) {
        return this.examenUsuarioRepository.findByIdEnfermedadUsuario(aId);
    }

    @Override
    @Transactional
    public ExamenUsuario createExamenUsuario(ExamenUsuario aExamenUsuario){
        return this.examenUsuarioRepository.save(aExamenUsuario);
    }

    @Override
    @Transactional
    public ExamenUsuario updateExamenUsuario(ExamenUsuario aExamenUsuario){
        return this.examenUsuarioRepository.save(aExamenUsuario);
    }

    @Override
    @Transactional
    public void deleteExamenUsuario(Long aId) {
        this.examenUsuarioRepository.deleteById(aId);
    }


    @Autowired
    public void setExamenUsuarioRepository(IExamenUsuarioRepository examenUsuarioRepository){
        this.examenUsuarioRepository = examenUsuarioRepository;
    }
}

