package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.TomaExamenDTO;
import com.software.checkhealtybackend.model.TomaExamen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TomaExamenMapper {

    TomaExamenMapper INSTANCE = Mappers.getMapper(TomaExamenMapper.class);

    // DTO's to Entity
    TomaExamen toTomaExamen(TomaExamenDTO aTomaExamenDTO);

    //Entity to DTO
    @Mapping(target = "idProgramacionExamen", source = "programacionExamen.id")
    TomaExamenDTO toTomaExamenDTO(TomaExamen aTomaExamen);
}