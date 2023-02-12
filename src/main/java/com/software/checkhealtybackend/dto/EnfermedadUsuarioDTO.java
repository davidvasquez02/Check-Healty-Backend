package com.software.checkhealtybackend.dto;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class EnfermedadUsuarioDTO implements Serializable {

    private static final long serialVersionUID = -2175930668508292882L;

    private Long id;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idEnfermedad;

    private String nombreUsuario;

    private String nombreEnfermedad;

}
