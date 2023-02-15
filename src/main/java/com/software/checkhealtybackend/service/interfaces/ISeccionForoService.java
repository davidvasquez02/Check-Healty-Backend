package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.SeccionForo;
import org.springframework.stereotype.Service;

@Service
public interface ISeccionForoService {

    SeccionForo findById (Long aId);

    SeccionForo createSeccionForo(SeccionForo aSeccionForo);

    SeccionForo updateSeccionForo(SeccionForo aSeccionForo);

    void deleteSeccionForo(Long aId);
}