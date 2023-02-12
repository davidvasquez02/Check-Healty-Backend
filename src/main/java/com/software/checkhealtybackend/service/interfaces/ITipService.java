package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Tip;
import org.springframework.stereotype.Service;

@Service
public interface ITipService {

    Tip findById (Long aId);

    Tip createTip(Tip aTip);

    Tip updateTip(Tip aTip);

    void deleteTip(Long aId);
}
