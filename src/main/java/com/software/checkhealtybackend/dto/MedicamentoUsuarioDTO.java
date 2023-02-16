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

    private static final long serialVersionUID = -5345862435502803275L;

    private Long id;

    @NotNull
    private Long idEnfermedadUsuario;

    private String nombre;

    //Programacion Medicamento
    
    @NotNull
    private Long idTipoFrecuencia;

    private String nombreTipoFrecuencia;

    private String multiplicadorTipoFrecuencia;

    @NotNull
    private Long idTipoDosis;

    private String nombreTipoDosis;

    private String dosis;

    private float frecuencia;

    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss", timezone = "America/Bogota")
    private Date fechaInicio;

    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss", timezone = "America/Bogota")
    private Date fechaFin;

}
