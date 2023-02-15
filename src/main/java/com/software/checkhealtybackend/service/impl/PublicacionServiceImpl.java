package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Publicacion;
import com.software.checkhealtybackend.repository.IPublicacionRepository;
import com.software.checkhealtybackend.service.interfaces.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublicacionServiceImpl implements IPublicacionService {

    private IPublicacionRepository publicacionRepository;


    @Override
    public Publicacion findById(Long aId) {
        return this.publicacionRepository.findById(aId).orElse(null);
    }


    //Obtiene una lista de publicaciones
    @Override
    public List<Publicacion> findAllPublicacion(Long idSeccion, Long idUsuario){
        return this.publicacionRepository.findAllByIdSeccionOrIdUsuario(idSeccion, idUsuario);
    }


    @Override
    @Transactional
    public Publicacion createPublicacion(Publicacion aPublicacion){
        return this.publicacionRepository.save(aPublicacion);
    }

    @Override
    @Transactional
    public Publicacion updatePublicacion(Publicacion aPublicacion){
        return this.publicacionRepository.save(aPublicacion);
    }

    @Override
    @Transactional
    public void deletePublicacion(Long aId) {
        this.publicacionRepository.deleteById(aId);
    }


    @Autowired
    public void setPublicacionRepository(IPublicacionRepository publicacionRepository){
        this.publicacionRepository = publicacionRepository;
    }
}
