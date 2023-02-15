package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Publicacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPublicacionService {

    Publicacion findById (Long aId);

    //Obtiene una lista de publicaciones
    List<Publicacion> findAllPublicacion(Long idSeccion, Long idUsuario);

    Publicacion createPublicacion(Publicacion aPublicacion);

    Publicacion updatePublicacion(Publicacion aPublicacion);

    void deletePublicacion(Long aId);
}