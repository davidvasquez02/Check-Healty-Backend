package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.NotificacionDTO;
import com.software.checkhealtybackend.model.Notificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificacionMapper {

    NotificacionMapper INSTANCE = Mappers.getMapper(NotificacionMapper.class);

    // DTO's to Entity
    Notificacion toNotificacion(NotificacionDTO aNotificacionDTO);

    //Entity to DTO
    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    NotificacionDTO toNotificacionDTO(Notificacion aNotificacion);
}
