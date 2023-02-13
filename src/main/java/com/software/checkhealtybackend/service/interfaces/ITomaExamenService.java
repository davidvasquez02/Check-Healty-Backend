package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.TomaExamen;
import org.springframework.stereotype.Service;

@Service
public interface ITomaExamenService {

    TomaExamen findById (Long aId);

    TomaExamen createTomaExamen(TomaExamen aTomaExamen);

    TomaExamen updateTomaExamen(TomaExamen aTomaExamen);

    void deleteTomaExamen(Long aId);
}