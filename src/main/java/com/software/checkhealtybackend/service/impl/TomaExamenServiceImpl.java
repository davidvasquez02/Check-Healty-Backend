package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.TomaExamen;
import com.software.checkhealtybackend.repository.ITomaExamenRepository;
import com.software.checkhealtybackend.service.interfaces.ITomaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TomaExamenServiceImpl implements ITomaExamenService {

    private ITomaExamenRepository tomaExamenRepository;


    @Override
    public TomaExamen findById(Long aId) {
        return this.tomaExamenRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public TomaExamen createTomaExamen(TomaExamen aTomaExamen){
        return this.tomaExamenRepository.save(aTomaExamen);
    }

    @Override
    @Transactional
    public TomaExamen updateTomaExamen(TomaExamen aTomaExamen){
        return this.tomaExamenRepository.save(aTomaExamen);
    }

    @Override
    @Transactional
    public void deleteTomaExamen(Long aId) {
        this.tomaExamenRepository.deleteById(aId);
    }

    @Override
    @Transactional
    public List<TomaExamen> findTomaExamenByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheck){
        return this.tomaExamenRepository.findTomaExamenByCheck(aIdUser, aFechaDesde, aFechaHasta, aCheck);
    }

    @Override
    @Transactional
    public List<TomaExamen> findAllByUser(Long aIdUser){
        return this.tomaExamenRepository.findTomaExamenByUser(aIdUser);
    }

    @Override
    @Transactional
    public List<TomaExamen> findAllBeforeCurrentDate(Long aIdUser){
        Date date = new Date();
        return this.tomaExamenRepository.findAllBeforeCurrentDate(aIdUser, date);
    }


    @Autowired
    public void setTomaExamenRepository(ITomaExamenRepository tomaExamenRepository){
        this.tomaExamenRepository = tomaExamenRepository;
    }
}
