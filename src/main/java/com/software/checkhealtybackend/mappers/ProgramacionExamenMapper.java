package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.ProgramacionExamenDTO;
import com.software.checkhealtybackend.model.ProgramacionExamen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramacionExamenMapper {

    ProgramacionExamenMapper INSTANCE = Mappers.getMapper(ProgramacionExamenMapper.class);

    // DTO's to Entity
    ProgramacionExamen toProgramacionExamen(ProgramacionExamenDTO aProgramacionExamenDTO);

    //Entity to DTO
    @Mapping(target = "idExamenUsuario", source = "examenUsuario.id")
    @Mapping(target = "nombreExamenUsuario", source = "examenUsuario.nombre")
    @Mapping(target = "idTipoFrecuencia", source = "tipoFrecuencia.id")
    @Mapping(target = "nombreTipoFrecuencia", source = "tipoFrecuencia.nombre")
    @Mapping(target = "idTipoMedida", source = "tipoMedida.id")
    @Mapping(target = "nombreTipoMedida", source = "tipoMedida.nombre")
    ProgramacionExamenDTO toProgramacionExamenDTO(ProgramacionExamen aProgramacionExamen);

}