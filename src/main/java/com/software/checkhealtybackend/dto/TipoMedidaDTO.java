package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TipoMedidaDTO implements Serializable {

    private static final long serialVersionUID = 8302515053321531858L;

    private Long id;

    @NotNull
    private String nombre;

    private String multiplicador;

}