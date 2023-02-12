package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.MedicamentoDTO;
import com.software.checkhealtybackend.model.Medicamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoMapper {

    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    // DTO's to Entity
    Medicamento toMedicamento(MedicamentoDTO aMedicamentoDTO);

    //Entity to DTO
    MedicamentoDTO toMedicamentoDTO(Medicamento aMedicamento);
}
