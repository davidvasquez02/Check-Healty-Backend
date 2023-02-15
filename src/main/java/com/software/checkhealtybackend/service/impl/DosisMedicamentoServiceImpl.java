package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.repository.IDosisMedicamentoRepository;
import com.software.checkhealtybackend.service.interfaces.IDosisMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DosisMedicamentoServiceImpl implements IDosisMedicamentoService {

    private IDosisMedicamentoRepository dosisMedicamentoRepository;


    @Override
    public DosisMedicamento findById(Long aId) {
        return this.dosisMedicamentoRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public DosisMedicamento createDosisMedicamento(DosisMedicamento aDosisMedicamento){
        return this.dosisMedicamentoRepository.save(aDosisMedicamento);
    }

    @Override
    @Transactional
    public DosisMedicamento updateDosisMedicamento(DosisMedicamento aDosisMedicamento){
        return this.dosisMedicamentoRepository.save(aDosisMedicamento);
    }

    @Override
    @Transactional
    public void deleteDosisMedicamento(Long aId) {
        this.dosisMedicamentoRepository.deleteById(aId);
    }

    @Override
    @Transactional
    public List<DosisMedicamento> findDosisMedicamentoByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheck){
        return this.dosisMedicamentoRepository.findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, aCheck);
    }

    @Override
    @Transactional
    public List<DosisMedicamento> findAllByUser(Long aIdUser){
        return this.dosisMedicamentoRepository.findDosisMedicamentoByUser(aIdUser);
    }


    @Autowired
    public void setDosisMedicamentoRepository(IDosisMedicamentoRepository dosisMedicamentoRepository){
        this.dosisMedicamentoRepository = dosisMedicamentoRepository;
    }
}
