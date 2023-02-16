package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EnfermedadUsuarioDTO implements Serializable {

    private static final long serialVersionUID = -2175930668508292882L;

    private Long id;

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idEnfermedad;

    private String nombreUsuario;

    private String nombreEnfermedad;
    private Boolean padece;

}
