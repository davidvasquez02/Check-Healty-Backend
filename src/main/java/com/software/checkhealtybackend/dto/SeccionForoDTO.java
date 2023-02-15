package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SeccionForoDTO implements Serializable {

    private static final long serialVersionUID = -7741765202975837815L;

    private Long id;

    @NotNull
    private String nombre;

    private String descripcion;

}
