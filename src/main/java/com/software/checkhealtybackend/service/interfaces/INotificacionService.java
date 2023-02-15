package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Notificacion;
import org.springframework.stereotype.Service;

@Service
public interface INotificacionService {

    Notificacion findById (Long aId);

    Notificacion createNotificacion(Notificacion aNotificacion);

    Notificacion updateNotificacion(Notificacion aNotificacion);

    void deleteNotificacion(Long aId);
}