package com.software.checkhealtybackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EnfermedadDTO implements Serializable {

    private static final long serialVersionUID = -2175930668508292882L;

    private Long id;

    @NotNull
    private String nombre;
}
