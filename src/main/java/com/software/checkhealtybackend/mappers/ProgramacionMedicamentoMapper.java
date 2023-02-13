package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.ProgramacionMedicamentoDTO;
import com.software.checkhealtybackend.model.ProgramacionMedicamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramacionMedicamentoMapper {

    ProgramacionMedicamentoMapper INSTANCE = Mappers.getMapper(ProgramacionMedicamentoMapper.class);

    // DTO's to Entity
    ProgramacionMedicamento toProgramacionMedicamento(ProgramacionMedicamentoDTO aProgramacionMedicamentoDTO);

    //Entity to DTO
    @Mapping(target = "idMedicamentoUsuario", source = "medicamentoUsuario.id")
    @Mapping(target = "nombreMedicamentoUsuario", source = "medicamentoUsuario.nombre")
    @Mapping(target = "idTipoFrecuencia", source = "tipoFrecuencia.id")
    @Mapping(target = "nombreTipoFrecuencia", source = "tipoFrecuencia.nombre")
    @Mapping(target = "idTipoDosis", source = "tipoDosis.id")
    @Mapping(target = "nombreTipoDosis", source = "tipoDosis.nombre")
    ProgramacionMedicamentoDTO toProgramacionMedicamentoDTO(ProgramacionMedicamento aProgramacionMedicamento);

}
