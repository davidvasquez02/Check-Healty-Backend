package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Comentario;
import org.springframework.stereotype.Service;

@Service
public interface IComentarioService {

    Comentario findById (Long aId);

    Comentario createMensaje(Comentario aComentario);

    Comentario updateMensaje(Comentario aComentario);

    void deleteMensaje(Long aId);
}