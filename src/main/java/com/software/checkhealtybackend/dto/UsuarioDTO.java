package com.software.checkhealtybackend.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 7063908162015284504L;

    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String correo;

    @NotNull
    private String contraseña;
}