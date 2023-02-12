package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Tip;
import com.software.checkhealtybackend.repository.ITipRepository;
import com.software.checkhealtybackend.service.interfaces.ITipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipServiceImpl implements ITipService {

    private ITipRepository tipRepository;


    @Override
    public Tip findById(Long aId) {
        return this.tipRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Tip createTip(Tip aTip){
        return this.tipRepository.save(aTip);
    }

    @Override
    @Transactional
    public Tip updateTip(Tip aTip){
        return this.tipRepository.save(aTip);
    }

    @Override
    @Transactional
    public void deleteTip(Long aId) {
        this.tipRepository.deleteById(aId);
    }


    @Autowired
    public void setTipRepository(ITipRepository tipRepository){
        this.tipRepository = tipRepository;
    }
}
