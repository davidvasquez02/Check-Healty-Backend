package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.SeccionForoDTO;
import com.software.checkhealtybackend.model.SeccionForo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeccionForoMapper {

    SeccionForoMapper INSTANCE = Mappers.getMapper(SeccionForoMapper.class);

    // DTO's to Entity
    SeccionForo toSeccionForo(SeccionForoDTO aSeccionForoDTO);

    //Entity to DTO
    SeccionForoDTO toSeccionForoDTO(SeccionForo aSeccionForo);
}
