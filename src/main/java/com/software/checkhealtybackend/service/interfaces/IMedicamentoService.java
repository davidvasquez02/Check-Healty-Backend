package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Medicamento;
import org.springframework.stereotype.Service;

@Service
public interface IMedicamentoService {

    Medicamento findById (Long aId);

    Medicamento createMedicamento(Medicamento aMedicamento);

    Medicamento updateMedicamento(Medicamento aMedicamento);

    void deleteMedicamento(Long aId);
}
