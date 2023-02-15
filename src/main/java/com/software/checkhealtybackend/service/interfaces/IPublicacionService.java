package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Publicacion;
import org.springframework.stereotype.Service;

@Service
public interface IPublicacionService {

    Publicacion findById (Long aId);

    Publicacion createPublicacion(Publicacion aPublicacion);

    Publicacion updatePublicacion(Publicacion aPublicacion);

    void deletePublicacion(Long aId);
}