package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.PublicacionDTO;
import com.software.checkhealtybackend.model.Publicacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicacionMapper {

    PublicacionMapper INSTANCE = Mappers.getMapper(PublicacionMapper.class);

    // DTO's to Entity
    Publicacion toPublicacion(PublicacionDTO aPublicacionDTO);

    //Entity to DTO
    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    @Mapping(target = "idSeccionForo", source = "seccionForo.id")
    @Mapping(target = "nombreSeccion", source = "seccionForo.nombre")
    PublicacionDTO toPublicacionDTO(Publicacion aPublicacion);

}