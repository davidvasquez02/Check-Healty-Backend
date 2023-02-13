package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.TipoDosisDTO;
import com.software.checkhealtybackend.model.TipoDosis;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoDosisMapper {
    TipoDosisMapper INSTANCE = Mappers.getMapper(TipoDosisMapper.class);

    // DTO's to Entity
    TipoDosis toTipoDosis(TipoDosisDTO aTipoDosisDTO);

    //Entity to DTO
    TipoDosisDTO toTipoDosisDTO(TipoDosis aTipoDosis);
}
