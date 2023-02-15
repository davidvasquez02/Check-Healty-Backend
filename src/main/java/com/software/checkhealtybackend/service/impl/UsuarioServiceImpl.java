package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Usuario;
import com.software.checkhealtybackend.repository.IUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;


    @Override
    public Usuario findById(Long aId) {
        return this.usuarioRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Usuario createUsuario(Usuario aUsuario){
        if(usuarioSimilar(aUsuario.getUsername())){return this.usuarioRepository.save(aUsuario);}else{return null;}
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario aUsuario){
        return this.usuarioRepository.save(aUsuario);
    }

    @Override
    @Transactional
    public void deleteUsuario(Long aId) {
        this.usuarioRepository.deleteById(aId);
    }

    //Inicio de sesion
    @Override
    @Transactional
    public Boolean sesionUsuario(String aUser, String aContraseña){
        return !this.usuarioRepository.sesionUsuario(aUser, aContraseña).isEmpty();
    }


    //Verificar usuarios similares

    @Transactional
    public Boolean usuarioSimilar(String aUser){
        return this.usuarioRepository.usuarioSimilar(aUser).isEmpty();
    }


    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
}
