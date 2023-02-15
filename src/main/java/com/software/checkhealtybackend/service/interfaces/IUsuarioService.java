package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {

    Usuario findById (Long aId);

    Usuario createUsuario(Usuario aUsuario);

    Usuario updateUsuario(Usuario aUsuario);

    void deleteUsuario(Long aId);

    Long sesionUsuario(String aUser, String aContraseña);

}
