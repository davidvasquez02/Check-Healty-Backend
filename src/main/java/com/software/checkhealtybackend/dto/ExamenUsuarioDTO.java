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
public class ExamenUsuarioDTO implements Serializable {

    private static final long serialVersionUID = 2113315265843739418L;

    private Long id;

    private String nombre;

    @NotNull
    private Long idEnfermedadUsuario;

    //Programacion Examen

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