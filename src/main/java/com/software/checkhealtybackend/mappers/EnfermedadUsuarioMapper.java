package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.EnfermedadUsuarioDTO;
import com.software.checkhealtybackend.model.EnfermedadUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnfermedadUsuarioMapper {

    EnfermedadUsuarioMapper INSTANCE = Mappers.getMapper(EnfermedadUsuarioMapper.class);

    // DTO's to Entity
    EnfermedadUsuario toEnfermedadUsuario(EnfermedadUsuarioDTO aEnfermedadUsuarioDTO);

    //Entity to DTO
    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    @Mapping(target = "nombreEnfermedad", source = "enfermedad.nombre")
    EnfermedadUsuarioDTO toEnfermedadUsuarioDTO(EnfermedadUsuario aEnfermedadUsuario);
}
