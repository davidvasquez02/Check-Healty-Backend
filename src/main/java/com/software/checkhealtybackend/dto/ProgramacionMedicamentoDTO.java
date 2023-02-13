package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProgramacionMedicamentoDTO {

    private static final long serialVersionUID = 4849355378588405119L;

    private Long id;

    @NotNull
    private Long idMedicamentoUsuario;

    private String nombreMedicamentoUsuario;

    @NotNull
    private Long idTipoFrecuencia;

    private String nombreTipoFrecuencia;

    @NotNull
    private Long idTipoDosis;

    private String nombreTipoDosis;

    private String dosis;

    private String frecuencia;

    private Date fechaInicio;



}
