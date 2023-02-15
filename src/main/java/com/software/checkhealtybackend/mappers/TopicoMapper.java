package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.TopicoDTO;
import com.software.checkhealtybackend.model.Topico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicoMapper {

    TopicoMapper INSTANCE = Mappers.getMapper(TopicoMapper.class);

    // DTO's to Entity
    Topico toTopico(TopicoDTO aTopicoDTO);

    //Entity to DTO
    @Mapping(target = "idSeccionForo", source = "seccionForo.id")
    @Mapping(target = "nombreSeccionForo", source = "seccionForo.nombre")
    TopicoDTO toTopicoDTO(Topico aTopico);

}
