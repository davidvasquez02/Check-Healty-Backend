package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.TipDTO;
import com.software.checkhealtybackend.model.Tip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipMapper {

    TipMapper INSTANCE = Mappers.getMapper(TipMapper.class);

    // DTO's to Entity
    Tip toTip(TipDTO aTipDTO);

    //Entity to DTO
    @Mapping(target = "idEnfermedad", source = "enfermedad.id")
    @Mapping(target = "nombreEnfermedad", source = "enfermedad.nombre")
    TipDTO toTipDTO(Tip aTip);
}
