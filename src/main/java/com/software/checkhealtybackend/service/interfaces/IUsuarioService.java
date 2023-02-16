package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.dto.UsuarioDTO;
import com.software.checkhealtybackend.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {

    Usuario findById (Long aId);

    UsuarioDTO createUsuario(UsuarioDTO aUsuario);

    Usuario updateUsuario(Usuario aUsuario);

    void deleteUsuario(Long aId);

    Usuario sesionUsuario(String aCorreo, String aContraseña);

}
