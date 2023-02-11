package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private IUsuarioService usuarioService;


    @Autowired
    public void setUsuarioService(IUsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
}
