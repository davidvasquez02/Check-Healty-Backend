package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.InformacionUsuario;
import com.software.checkhealtybackend.repository.IInformacionUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IInformacionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InformacionUsuarioServiceImpl implements IInformacionUsuarioService {

    private IInformacionUsuarioRepository informacionUsuarioRepository;

    @Override
    public InformacionUsuario findById(Long aId) {
        return this.informacionUsuarioRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public InformacionUsuario createInformacionUsuario(InformacionUsuario aInformacionUsuario){
        return this.informacionUsuarioRepository.save(aInformacionUsuario);
    }

    @Override
    @Transactional
    public InformacionUsuario updateInformacionUsuario(InformacionUsuario aInformacionUsuario){
        return this.informacionUsuarioRepository.save(aInformacionUsuario);
    }

    @Override
    @Transactional
    public void deleteInformacionUsuario(Long aId) {
        this.informacionUsuarioRepository.deleteById(aId);
    }


    @Autowired
    public void setInformacionUsuarioRepository(IInformacionUsuarioRepository informacionUsuarioRepository){
        this.informacionUsuarioRepository = informacionUsuarioRepository;
    }
}

