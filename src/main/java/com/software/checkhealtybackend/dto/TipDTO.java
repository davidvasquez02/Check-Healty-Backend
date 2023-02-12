package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TipDTO implements Serializable {

    private static final long serialVersionUID = -1506210855960133353L;

    private Long id;

    @NotNull
    private Long idEnfermedad;

    private String descripcion;

    private String nombreEnfermedad;
}
