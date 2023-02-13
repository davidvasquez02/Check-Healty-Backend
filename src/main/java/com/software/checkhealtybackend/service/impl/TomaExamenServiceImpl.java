package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.TomaExamen;
import com.software.checkhealtybackend.repository.ITomaExamenRepository;
import com.software.checkhealtybackend.service.interfaces.ITomaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Autowired
    public void setTomaExamenRepository(ITomaExamenRepository tomaExamenRepository){
        this.tomaExamenRepository = tomaExamenRepository;
    }
}
