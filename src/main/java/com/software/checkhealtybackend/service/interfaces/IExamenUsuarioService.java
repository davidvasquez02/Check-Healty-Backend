package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.ExamenUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExamenUsuarioService {

    List<ExamenUsuario> findById (Long aId);

    ExamenUsuario createExamenUsuario(ExamenUsuario aExamenUsuario);

    ExamenUsuario updateExamenUsuario(ExamenUsuario aExamenUsuario);

    void deleteExamenUsuario(Long aId);
}