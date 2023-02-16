package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.repository.IDosisMedicamentoRepository;
import com.software.checkhealtybackend.service.interfaces.IDosisMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
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
    public List<List<List<String>>> findEstadistica (Long aIdUser){

        List<List<List<String>>> listAll =new ArrayList<>();
        List<String> cantidadFalseString = new ArrayList<>();
        List<String> cantidadTrueString = new ArrayList<>();
        Date aFechaDesde = new Date();
        aFechaDesde.setDate(1);
        Date aFechaHasta =new Date();
        aFechaHasta.setDate(1);


        aFechaDesde.setMonth(Calendar.JANUARY);
        aFechaHasta.setMonth(Calendar.FEBRUARY);
        Integer aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, true).size();
        cantidadTrueString.add(aux.toString());
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, false).size();
        cantidadFalseString.add(aux.toString());
        aFechaDesde.setMonth(Calendar.FEBRUARY);
        aFechaHasta.setMonth(Calendar.MARCH);
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, true).size();
        cantidadTrueString.add(aux.toString());
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, false).size();
        cantidadFalseString.add(aux.toString());
        aFechaDesde.setMonth(Calendar.MARCH);
        aFechaHasta.setMonth(Calendar.APRIL);
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, true).size();
        cantidadTrueString.add(aux.toString());
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, false).size();
        cantidadFalseString.add(aux.toString());
        aFechaDesde.setMonth(Calendar.APRIL);
        aFechaHasta.setMonth(Calendar.MAY);
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, true).size();
        cantidadTrueString.add(aux.toString());
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, false).size();
        cantidadFalseString.add(aux.toString());
        aFechaDesde.setMonth(Calendar.MAY);
        aFechaHasta.setMonth(Calendar.JUNE);
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, true).size();
        cantidadTrueString.add(aux.toString());
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, false).size();
        cantidadFalseString.add(aux.toString());
        aFechaDesde.setMonth(Calendar.JUNE);
        aFechaHasta.setMonth(Calendar.JULY);
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, true).size();
        cantidadTrueString.add(aux.toString());
        aux = findDosisMedicamentoByCheck(aIdUser, aFechaDesde, aFechaHasta, false).size();
        cantidadFalseString.add(aux.toString());

        List<String> labelTrue = new ArrayList<>();
        labelTrue.add("Toma");

        List<String> labelFalse = new ArrayList<>();
        labelFalse.add("No Toma");

        List<List<String>> listTrue = new ArrayList<>();
        listTrue.add(cantidadTrueString);
        listTrue.add(labelTrue);

        List<List<String>> listFalse = new ArrayList<>();
        listFalse.add(cantidadFalseString);
        listFalse.add(labelFalse);

        listAll.add(listTrue);
        listAll.add(listFalse);

        return listAll;
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
