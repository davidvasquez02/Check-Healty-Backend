package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.ProgramacionExamen;
import org.springframework.stereotype.Service;

@Service
public interface IProgramacionExamenService {

    ProgramacionExamen findById (Long aId);

    ProgramacionExamen createProgramacionExamen(ProgramacionExamen aProgramacionExamen);

    ProgramacionExamen updateProgramacionExamen(ProgramacionExamen aProgramacionExamen);

    void deleteProgramacionExamen(Long aId);
}