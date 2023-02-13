package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProgramacionExamenDTO implements Serializable {

    private static final long serialVersionUID = 4849355378588405119L;

    private Long id;

    @NotNull
    private Long idExamenUsuario;

    private String nombreExamenUsuario;

    @NotNull
    private Long idTipoFrecuencia;

    private String nombreTipoFrecuencia;

    @NotNull
    private Long idTipoMedida;

    private String nombreTipoMedida;

    private String frecuencia;

    private Date fechaInicio;

    private String medidaMax;

    private String medidaMin;

}

