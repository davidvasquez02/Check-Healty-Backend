package com.software.checkhealtybackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MedicamentoDTO implements Serializable {

    private static final long serialVersionUID = -3067244168391522589L;

    private Long id;

    @NotNull
    private String nombre;
}
