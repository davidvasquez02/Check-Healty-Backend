package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.model.DosisMedicamento;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IDosisMedicamentoService {

    DosisMedicamento findById (Long aId);

    DosisMedicamento createDosisMedicamento(DosisMedicamento aDosisMedicamento);

    DosisMedicamento updateDosisMedicamento(DosisMedicamento aDosisMedicamento);

    void deleteDosisMedicamento(Long aId);

    List<DosisMedicamento> findDosisMedicamentoByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheck);

    List<DosisMedicamento> findAllByUser(Long aIdUser);
}