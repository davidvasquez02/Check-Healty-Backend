package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.InformacionUsuarioDTO;
import com.software.checkhealtybackend.model.InformacionUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InformacionUsuarioMapper {

    InformacionUsuarioMapper INSTANCE = Mappers.getMapper(InformacionUsuarioMapper.class);

    // DTO's to Entity
    InformacionUsuario toInformacionUsuario(InformacionUsuarioDTO aInformacionUsuarioDTO);

    //Entity to DTO
    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    InformacionUsuarioDTO toInformacionUsuarioDTO(InformacionUsuario aInformacionUsuario);
}
