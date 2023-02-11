package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.repository.IUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
}
