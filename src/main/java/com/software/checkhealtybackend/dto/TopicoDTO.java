package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TopicoDTO implements Serializable {

    private static final long serialVersionUID = 1805929604137148136L;

    private Long id;

    @NotNull
    private Long idSeccionForo;

    private String nombreSeccionForo;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

}