package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.DosisMedicamento;
import org.springframework.stereotype.Service;

@Service
public interface IDosisMedicamentoService {

    DosisMedicamento findById (Long aId);

    DosisMedicamento createDosisMedicamento(DosisMedicamento aDosisMedicamento);

    DosisMedicamento updateDosisMedicamento(DosisMedicamento aDosisMedicamento);

    void deleteDosisMedicamento(Long aId);
}