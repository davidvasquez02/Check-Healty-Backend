package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.TipoFrecuenciaDTO;
import com.software.checkhealtybackend.model.TipoFrecuencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoFrecuenciaMapper {
    TipoFrecuenciaMapper INSTANCE = Mappers.getMapper(TipoFrecuenciaMapper.class);

    // DTO's to Entity
    TipoFrecuencia toTipoFrecuencia(TipoFrecuenciaDTO aTipoFrecuenciaDTO);

    //Entity to DTO
    TipoFrecuenciaDTO toTipoFrecuenciaDTO(TipoFrecuencia aTipoFrecuencia);
}
