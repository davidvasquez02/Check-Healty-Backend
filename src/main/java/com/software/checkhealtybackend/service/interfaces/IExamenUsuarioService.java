package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.ExamenUsuario;
import org.springframework.stereotype.Service;

@Service
public interface IExamenUsuarioService {

    ExamenUsuario findById (Long aId);

    ExamenUsuario createExamenUsuario(ExamenUsuario aExamenUsuario);

    ExamenUsuario updateExamenUsuario(ExamenUsuario aExamenUsuario);

    void deleteExamenUsuario(Long aId);
}