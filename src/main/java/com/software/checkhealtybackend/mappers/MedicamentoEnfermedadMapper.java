package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.MedicamentoEnfermedadDTO;
import com.software.checkhealtybackend.model.MedicamentoEnfermedad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoEnfermedadMapper {

    MedicamentoEnfermedadMapper INSTANCE = Mappers.getMapper(MedicamentoEnfermedadMapper.class);

    // DTO's to Entity
    MedicamentoEnfermedad toMedicamentoEnfermedad(MedicamentoEnfermedadDTO aMedicamentoEnfermedadDTO);

    //Entity to DTO
    @Mapping(target = "idMedicamento", source = "medicamento.id")
    @Mapping(target = "nombreMedicamento", source = "medicamento.nombre")
    @Mapping(target = "idEnfermedad", source = "enfermedad.id")
    @Mapping(target = "nombreEnfermedad", source = "enfermedad.nombre")
    MedicamentoEnfermedadDTO toMedicamentoEnfermedadDTO(MedicamentoEnfermedad aMedicamentoEnfermedad);
}