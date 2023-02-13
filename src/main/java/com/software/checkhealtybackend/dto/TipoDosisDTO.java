package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TipoDosisDTO implements Serializable {

    private static final long serialVersionUID = -5660594292206552518L;

    private Long id;

    @NotNull
    private String nombre;

    private String multiplicador;

}