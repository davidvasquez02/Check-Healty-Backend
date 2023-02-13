package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.DosisMedicamentoDTO;
import com.software.checkhealtybackend.model.DosisMedicamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DosisMedicamentoMapper {

    DosisMedicamentoMapper INSTANCE = Mappers.getMapper(DosisMedicamentoMapper.class);

    // DTO's to Entity
    DosisMedicamento toDosisMedicamento(DosisMedicamentoDTO aDosisMedicamentoDTO);

    //Entity to DTO
    @Mapping(target = "idProgramacionMedicamento", source = "programacionMedicamento.id")
    DosisMedicamentoDTO toDosisMedicamentoDTO(DosisMedicamento aDosisMedicamento);
}
