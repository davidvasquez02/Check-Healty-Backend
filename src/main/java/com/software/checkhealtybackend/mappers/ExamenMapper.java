package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.ExamenDTO;
import com.software.checkhealtybackend.model.Examen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamenMapper {

    ExamenMapper INSTANCE = Mappers.getMapper(ExamenMapper.class);

    // DTO's to Entity
    Examen toExamen(ExamenDTO aExamenDTO);

    //Entity to DTO
    ExamenDTO toExamenDTO(Examen aExamen);
}
