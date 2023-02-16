package com.software.checkhealtybackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MedicamentoUsuarioDTO implements Serializable {

    private static final long serialVersionUID = -7759919656031580999L;

    private Long id;

    @NotNull
    private Long idEnfermedadUsuario;

    private String nombre;

    //Programacion Medicamento
    
    @NotNull
    private Long idTipoFrecuencia;

    private String nombreTipoFrecuencia;

    @NotNull
    private Long idTipoDosis;

    private String nombreTipoDosis;

    private String dosis;

    private String frecuencia;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fechaInicio;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fechaFin;

}
