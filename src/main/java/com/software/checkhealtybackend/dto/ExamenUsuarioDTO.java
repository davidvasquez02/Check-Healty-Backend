package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExamenUsuarioDTO {

    private static final long serialVersionUID = 2113315265843739418L;

    private Long id;

    private String nombre;

    @NotNull
    private Long idEnfermedadUsuario;

}