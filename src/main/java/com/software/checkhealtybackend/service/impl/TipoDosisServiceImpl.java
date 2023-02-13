package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.TipoDosis;
import com.software.checkhealtybackend.repository.ITipoDosisRepository;
import com.software.checkhealtybackend.service.interfaces.ITipoDosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoDosisServiceImpl implements ITipoDosisService {

    private ITipoDosisRepository tipoDosisRepository;


    @Override
    public TipoDosis findById(Long aId) {
        return this.tipoDosisRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public TipoDosis createTipoDosis(TipoDosis aTipoDosis){
        return this.tipoDosisRepository.save(aTipoDosis);
    }

    @Override
    @Transactional
    public TipoDosis updateTipoDosis(TipoDosis aTipoDosis){
        return this.tipoDosisRepository.save(aTipoDosis);
    }

    @Override
    @Transactional
    public void deleteTipoDosis(Long aId) {
        this.tipoDosisRepository.deleteById(aId);
    }


    @Autowired
    public void setTipRepository(ITipoDosisRepository tipoDosisRepository){
        this.tipoDosisRepository = tipoDosisRepository;
    }
}