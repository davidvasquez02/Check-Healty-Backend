package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.TipoDosis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITipoDosisService  {

    TipoDosis findById (Long aId);

    TipoDosis createTipoDosis(TipoDosis aTipoDosis);

    TipoDosis updateTipoDosis(TipoDosis aTipoDosis);

    void deleteTipoDosis(Long aId);

    List<TipoDosis> findAll();

}