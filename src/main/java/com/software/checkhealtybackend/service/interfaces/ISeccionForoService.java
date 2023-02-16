package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.SeccionForo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISeccionForoService {

    SeccionForo findById (Long aId);

    //Obtiene todas las secciones
    List<SeccionForo> getAll();

    SeccionForo createSeccionForo(SeccionForo aSeccionForo);

    SeccionForo updateSeccionForo(SeccionForo aSeccionForo);

    void deleteSeccionForo(Long aId);
}