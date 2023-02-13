package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.ProgramacionMedicamento;
import org.springframework.stereotype.Service;

@Service
public interface IProgramacionMedicamentoService {

    ProgramacionMedicamento findById (Long aId);

    ProgramacionMedicamento createProgramacionMedicamento(ProgramacionMedicamento aProgramacionMedicamento);

    ProgramacionMedicamento updateProgramacionMedicamento(ProgramacionMedicamento aProgramacionMedicamento);

    void deleteProgramacionMedicamento(Long aId);
}