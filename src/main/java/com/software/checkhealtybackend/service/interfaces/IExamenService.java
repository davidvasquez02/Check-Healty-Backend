package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Examen;
import org.springframework.stereotype.Service;

@Service
public interface IExamenService {

    Examen findById (Long aId);

    Examen createExamen(Examen aExamen);

    Examen updateExamen(Examen aExamen);

    void deleteExamen(Long aId);
}
