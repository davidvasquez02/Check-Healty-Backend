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
    @Mapping(target = "idMedicamentoUsuario", source = "medicamentoUsuario.id")
    @Mapping(target = "idEnfermedadUsuario", source = "medicamentoUsuario.idEnfermedadUsuario")
    @Mapping(target = "nombre", source = "medicamentoUsuario.nombre")
    @Mapping(target = "dosis", source = "medicamentoUsuario.dosis")
    @Mapping(target = "nombreTipoDosis", source = "medicamentoUsuario.tipoDosis.nombre")
    DosisMedicamentoDTO toDosisMedicamentoDTO(DosisMedicamento aDosisMedicamento);
}
