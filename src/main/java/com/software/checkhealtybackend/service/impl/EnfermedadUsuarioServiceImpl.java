package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.EnfermedadUsuario;
import com.software.checkhealtybackend.repository.IEnfermedadUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IEnfermedadUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnfermedadUsuarioServiceImpl implements IEnfermedadUsuarioService {

    private IEnfermedadUsuarioRepository enfermedadUsuarioRepository;


    @Override
    public EnfermedadUsuario findById(Long aId) {
        return this.enfermedadUsuarioRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public EnfermedadUsuario createEnfermedadUsuario(EnfermedadUsuario aEnfermedadUsuario){
        return this.enfermedadUsuarioRepository.save(aEnfermedadUsuario);
    }

    @Override
    @Transactional
    public EnfermedadUsuario updateEnfermedadUsuario(EnfermedadUsuario aEnfermedadUsuario){
        return this.enfermedadUsuarioRepository.save(aEnfermedadUsuario);
    }

    @Override
    @Transactional
    public void deleteEnfermedadUsuario(Long aId) {
        this.enfermedadUsuarioRepository.deleteById(aId);
    }


    @Autowired
    public void setEnfermedadUsuarioRepository(IEnfermedadUsuarioRepository enfermedadUsuarioRepository){
        this.enfermedadUsuarioRepository = enfermedadUsuarioRepository;
    }
}
