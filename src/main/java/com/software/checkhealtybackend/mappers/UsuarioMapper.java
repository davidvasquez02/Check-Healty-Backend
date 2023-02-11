package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.UsuarioDTO;
import com.software.checkhealtybackend.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // DTO's to Entity
    Usuario toUsuario(UsuarioDTO aUsuarioDTO);

    //Entity to DTO
    UsuarioDTO toUsuarioDTO(Usuario aUsuario);
}
