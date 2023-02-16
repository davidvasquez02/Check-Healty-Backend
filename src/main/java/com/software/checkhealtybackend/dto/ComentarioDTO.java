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
public class ComentarioDTO implements Serializable {

    private static final long serialVersionUID = 18364063442408585L;

    private Long id;
    @NotNull
    private Long idPublicacion;
    @NotNull
    private Long idUsuario;
    private String nombreUsuario;
    private Date fecha;
    private String contenido;

}