package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class NotificacionDTO implements Serializable {

    private static final long serialVersionUID = 4278556079153861757L;

    private Long id;

    @NotNull
    private Long idUsuario;

    private String nombreUsuario;

    private String titulo;

    private String descripcion;

    private Boolean leida;

}