package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.SeccionForo;
import com.software.checkhealtybackend.repository.ISeccionForoRepository;
import com.software.checkhealtybackend.service.interfaces.ISeccionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeccionForoServiceImpl implements ISeccionForoService {

    private ISeccionForoRepository seccionForoRepository;


    @Override
    public SeccionForo findById(Long aId) {
        return this.seccionForoRepository.findById(aId).orElse(null);
    }

    //Obtiene todas las secciones
    @Override
    public List<SeccionForo> getAll(){
        return this.seccionForoRepository.findAll();
    }

    @Override
    @Transactional
    public SeccionForo createSeccionForo(SeccionForo aSeccionForo){
        return this.seccionForoRepository.save(aSeccionForo);
    }

    @Override
    @Transactional
    public SeccionForo updateSeccionForo(SeccionForo aSeccionForo){
        return this.seccionForoRepository.save(aSeccionForo);
    }

    @Override
    @Transactional
    public void deleteSeccionForo(Long aId) {
        this.seccionForoRepository.deleteById(aId);
    }


    @Autowired
    public void setSeccionForoRepository(ISeccionForoRepository seccionForoRepository){
        this.seccionForoRepository = seccionForoRepository;
    }
}
