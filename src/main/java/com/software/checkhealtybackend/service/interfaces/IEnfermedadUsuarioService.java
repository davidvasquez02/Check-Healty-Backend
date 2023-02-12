package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.EnfermedadUsuario;
import org.springframework.stereotype.Service;

@Service
public interface IEnfermedadUsuarioService {

    EnfermedadUsuario findById (Long aId);

    EnfermedadUsuario createEnfermedadUsuario(EnfermedadUsuario aEnfermedadUsuario);

    EnfermedadUsuario updateEnfermedadUsuario(EnfermedadUsuario aEnfermedadUsuario);

    void deleteEnfermedadUsuario(Long aId);
}
