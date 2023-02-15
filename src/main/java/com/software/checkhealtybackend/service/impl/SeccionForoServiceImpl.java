package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.SeccionForo;
import com.software.checkhealtybackend.repository.ISeccionForoRepository;
import com.software.checkhealtybackend.service.interfaces.ISeccionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeccionForoServiceImpl implements ISeccionForoService {

    private ISeccionForoRepository notificacionRepository;


    @Override
    public SeccionForo findById(Long aId) {
        return this.notificacionRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public SeccionForo createSeccionForo(SeccionForo aSeccionForo){
        return this.notificacionRepository.save(aSeccionForo);
    }

    @Override
    @Transactional
    public SeccionForo updateSeccionForo(SeccionForo aSeccionForo){
        return this.notificacionRepository.save(aSeccionForo);
    }

    @Override
    @Transactional
    public void deleteSeccionForo(Long aId) {
        this.notificacionRepository.deleteById(aId);
    }


    @Autowired
    public void setSeccionForoRepository(ISeccionForoRepository notificacionRepository){
        this.notificacionRepository = notificacionRepository;
    }
}
