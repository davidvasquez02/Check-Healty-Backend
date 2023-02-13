package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.TipoMedidaDTO;
import com.software.checkhealtybackend.model.TipoMedida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TipoMedidaMapper {
    TipoMedidaMapper INSTANCE = Mappers.getMapper(TipoMedidaMapper.class);

    // DTO's to Entity
    TipoMedida toTipoMedida(TipoMedidaDTO aTipoMedidaDTO);

    //Entity to DTO
    TipoMedidaDTO toTipoMedidaDTO(TipoMedida aTipoMedida);
}
