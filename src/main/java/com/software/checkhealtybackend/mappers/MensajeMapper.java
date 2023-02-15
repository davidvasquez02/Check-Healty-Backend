package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.MensajeDTO;
import com.software.checkhealtybackend.model.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MensajeMapper {

    MensajeMapper INSTANCE = Mappers.getMapper(MensajeMapper.class);

    // DTO's to Entity
    Mensaje toMensaje(MensajeDTO aMensajeDTO);

    //Entity to DTO
    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    @Mapping(target = "idPublicacion", source = "publicacion.id")
    @Mapping(target = "nombrePublicacion", source = "publicacion.titulo")
    MensajeDTO toMensajeDTO(Mensaje aMensaje);

}
