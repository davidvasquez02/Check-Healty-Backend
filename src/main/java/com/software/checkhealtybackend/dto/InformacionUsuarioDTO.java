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
public class InformacionUsuarioDTO implements Serializable {

    private static final long serialVersionUID = 5273039482689620693L;

    private Long id;

    @NotNull
    private Long idUsuario;

    private String nombreUsuario;

    private String alturaMt;

    private String pesoKg;

    private Date fechaNacimiento;
}
