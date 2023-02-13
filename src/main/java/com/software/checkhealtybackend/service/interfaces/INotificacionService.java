package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Notificacion;

public interface INotificacionService {

    Notificacion findById (Long aId);

    Notificacion createNotificacion(Notificacion aNotificacion);

    Notificacion updateNotificacion(Notificacion aNotificacion);

    void deleteNotificacion(Long aId);
}