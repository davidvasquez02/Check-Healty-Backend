package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Enfermedad;
import org.springframework.stereotype.Service;

@Service
public interface IEnfermedadService {

    Enfermedad findById (Long aId);

    Enfermedad createEnfermedad(Enfermedad aEnfermedad);

    Enfermedad updateEnfermedad(Enfermedad aEnfermedad);

    void deleteEnfermedad(Long aId);
}
