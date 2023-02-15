package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Mensaje;
import com.software.checkhealtybackend.repository.IMensajeRepository;
import com.software.checkhealtybackend.service.interfaces.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MensajeServiceImpl implements IMensajeService {
    private IMensajeRepository mensajeRepository;

    @Override
    public Mensaje findById(Long aId) {
        return this.mensajeRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Mensaje createMensaje(Mensaje aMensaje){
        return this.mensajeRepository.save(aMensaje);
    }

    @Override
    @Transactional
    public Mensaje updateMensaje(Mensaje aMensaje){
        return this.mensajeRepository.save(aMensaje);
    }

    @Override
    @Transactional
    public void deleteMensaje(Long aId) {
        this.mensajeRepository.deleteById(aId);
    }


    @Autowired
    public void setMensajeRepository(IMensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }
}
