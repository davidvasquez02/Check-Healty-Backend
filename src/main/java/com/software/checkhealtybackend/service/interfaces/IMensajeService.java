package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Mensaje;
import org.springframework.stereotype.Service;

@Service
public interface IMensajeService {

    Mensaje findById (Long aId);

    Mensaje createMensaje(Mensaje aMensaje);

    Mensaje updateMensaje(Mensaje aMensaje);

    void deleteMensaje(Long aId);
}