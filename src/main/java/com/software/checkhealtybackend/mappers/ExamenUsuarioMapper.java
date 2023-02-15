package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.ExamenUsuarioDTO;
import com.software.checkhealtybackend.model.ExamenUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamenUsuarioMapper {

    ExamenUsuarioMapper INSTANCE = Mappers.getMapper(ExamenUsuarioMapper.class);

    // DTO's to Entity
    ExamenUsuario toExamenUsuario(ExamenUsuarioDTO aExamenUsuarioDTO);

    //Entity to DTO
    @Mapping(target = "idEnfermedadUsuario", source = "enfermedadUsuario.id") //ProgramacionExamen
    @Mapping(target = "idTipoFrecuencia", source = "tipoFrecuencia.id")
    @Mapping(target = "nombreTipoFrecuencia", source = "tipoFrecuencia.nombre")
    @Mapping(target = "idTipoMedida", source = "tipoMedida.id")
    @Mapping(target = "nombreTipoMedida", source = "tipoMedida.nombre")
    ExamenUsuarioDTO toExamenUsuarioDTO(ExamenUsuario aExamenUsuario);
}
