package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.TomaExamen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public interface ITomaExamenService {

    TomaExamen findById (Long aId);

    TomaExamen createTomaExamen(TomaExamen aTomaExamen);

    TomaExamen updateTomaExamen(TomaExamen aTomaExamen);

    void deleteTomaExamen(Long aId);

    List<TomaExamen> findTomaExamenByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheck);

    List<TomaExamen> findAllByUser(Long aIdUser);

    @Transactional
    List<TomaExamen> findAllBeforeCurrentDate(Long aIdUser);
}