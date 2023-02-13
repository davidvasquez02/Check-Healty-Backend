package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.ExamenEnfermedadDTO;
import com.software.checkhealtybackend.model.ExamenEnfermedad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamenEnfermedadMapper {

    ExamenEnfermedadMapper INSTANCE = Mappers.getMapper(ExamenEnfermedadMapper.class);

    // DTO's to Entity
    ExamenEnfermedad toExamenEnfermedad(ExamenEnfermedadDTO aExamenEnfermedadDTO);

    //Entity to DTO
    @Mapping(target = "idExamen", source = "examen.id")
    @Mapping(target = "nombreExamen", source = "examen.nombre")
    @Mapping(target = "idEnfermedad", source = "enfermedad.id")
    @Mapping(target = "nombreEnfermedad", source = "enfermedad.nombre")
    ExamenEnfermedadDTO toExamenEnfermedadDTO(ExamenEnfermedad aExamenEnfermedad);

}
