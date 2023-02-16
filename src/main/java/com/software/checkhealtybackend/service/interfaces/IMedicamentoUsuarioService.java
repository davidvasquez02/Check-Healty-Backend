package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.MedicamentoUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMedicamentoUsuarioService {

    List<MedicamentoUsuario> findById (Long aId);

    MedicamentoUsuario createMedicamentoUsuario(MedicamentoUsuario aMedicamentoUsuario);

    MedicamentoUsuario updateMedicamentoUsuario(MedicamentoUsuario aMedicamentoUsuario);

    void deleteMedicamentoUsuario(Long aId);
}