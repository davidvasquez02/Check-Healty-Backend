package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.ComentarioDTO;
import com.software.checkhealtybackend.model.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComentarioMapper {

    ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);

    // DTO's to Entity
    Comentario toMensaje(ComentarioDTO aComentarioDTO);

    //Entity to DTO
    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    @Mapping(target = "idPublicacion", source = "publicacion.id")
    ComentarioDTO toMensajeDTO(Comentario aComentario);

}
