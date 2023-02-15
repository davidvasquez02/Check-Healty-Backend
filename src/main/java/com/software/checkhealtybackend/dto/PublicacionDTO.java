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
public class PublicacionDTO implements Serializable {

    private static final long serialVersionUID = 1960119109088203579L;

    private Long id;

    @NotNull
    private Long idSeccionForo;

    private String nombreSeccion;

    @NotNull
    private Long idUsuario;

    private String nombreUsuario;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date fecha;

    private String contenido;

}