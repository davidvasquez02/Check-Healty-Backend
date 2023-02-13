package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.MedicamentoEnfermedad;
import org.springframework.stereotype.Service;

@Service
public interface IMedicamentoEnfermedadService {

    MedicamentoEnfermedad findById (Long aId);

    MedicamentoEnfermedad createMedicamentoEnfermedad(MedicamentoEnfermedad aMedicamentoEnfermedad);

    MedicamentoEnfermedad updateMedicamentoEnfermedad(MedicamentoEnfermedad aMedicamentoEnfermedad);

    void deleteMedicamentoEnfermedad(Long aId);
}