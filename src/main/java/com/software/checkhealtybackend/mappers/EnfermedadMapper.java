package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.EnfermedadDTO;
import com.software.checkhealtybackend.model.Enfermedad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnfermedadMapper {

    EnfermedadMapper INSTANCE = Mappers.getMapper(EnfermedadMapper.class);

    // DTO's to Entity
    Enfermedad toEnfermedad(EnfermedadDTO aEnfermedadDTO);

    //Entity to DTO
    EnfermedadDTO toEnfermedadDTO(Enfermedad aEnfermedad);
}
