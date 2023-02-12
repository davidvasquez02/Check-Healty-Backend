package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ExamenDTO implements Serializable {

    private static final long serialVersionUID = -6313781282140419606L;

    private Long id;

    @NotNull
    private String nombre;

    private String medida;
}
