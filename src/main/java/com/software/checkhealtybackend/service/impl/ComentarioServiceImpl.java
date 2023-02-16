package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Comentario;
import com.software.checkhealtybackend.repository.IComentarioRepository;
import com.software.checkhealtybackend.service.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServiceImpl implements IComentarioService {
    private IComentarioRepository mensajeRepository;

    @Override
    public Comentario findById(Long aId) {
        return this.mensajeRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Comentario createMensaje(Comentario aComentario){
        return this.mensajeRepository.save(aComentario);
    }

    @Override
    @Transactional
    public Comentario updateMensaje(Comentario aComentario){
        return this.mensajeRepository.save(aComentario);
    }

    @Override
    @Transactional
    public void deleteMensaje(Long aId) {
        this.mensajeRepository.deleteById(aId);
    }


    @Autowired
    public void setMensajeRepository(IComentarioRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }
}
