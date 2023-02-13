package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicamentoUsuarioDTO {

    private static final long serialVersionUID = -7759919656031580999L;

    private Long id;

    @NotNull
    private Long idEnfermedadUsuario;

    private String nombre;

}
