package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Notificacion;
import com.software.checkhealtybackend.repository.INotificacionRepository;
import com.software.checkhealtybackend.service.interfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificacionServiceImpl implements INotificacionService {

    private INotificacionRepository notificacionRepository;


    @Override
    public Notificacion findById(Long aId) {
        return this.notificacionRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Notificacion createNotificacion(Notificacion aNotificacion){
        return this.notificacionRepository.save(aNotificacion);
    }

    @Override
    @Transactional
    public Notificacion updateNotificacion(Notificacion aNotificacion){
        return this.notificacionRepository.save(aNotificacion);
    }

    @Override
    @Transactional
    public void deleteNotificacion(Long aId) {
        this.notificacionRepository.deleteById(aId);
    }


    @Autowired
    public void setNotificacionRepository(INotificacionRepository notificacionRepository){
        this.notificacionRepository = notificacionRepository;
    }
}
