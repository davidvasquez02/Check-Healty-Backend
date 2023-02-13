package com.software.checkhealtybackend.mappers;

import com.software.checkhealtybackend.dto.MedicamentoUsuarioDTO;
import com.software.checkhealtybackend.model.MedicamentoUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicamentoUsuarioMapper {

    MedicamentoUsuarioMapper INSTANCE = Mappers.getMapper(MedicamentoUsuarioMapper.class);

    // DTO's to Entity
    MedicamentoUsuario toMedicamentoUsuario(MedicamentoUsuarioDTO aMedicamentoUsuarioDTO);

    //Entity to DTO
    @Mapping(target = "idEnfermedadUsuario", source = "enfermedadUsuario.id")
    MedicamentoUsuarioDTO toMedicamentoUsuarioDTO(MedicamentoUsuario aMedicamentoUsuario);
}
