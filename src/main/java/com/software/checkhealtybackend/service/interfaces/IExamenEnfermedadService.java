package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.ExamenEnfermedad;
import org.springframework.stereotype.Service;

@Service
public interface IExamenEnfermedadService {

    ExamenEnfermedad findById (Long aId);

    ExamenEnfermedad createExamenEnfermedad(ExamenEnfermedad aExamenEnfermedad);

    ExamenEnfermedad updateExamenEnfermedad(ExamenEnfermedad aExamenEnfermedad);

    void deleteExamenEnfermedad(Long aId);
}