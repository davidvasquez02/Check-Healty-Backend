package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ExamenEnfermedadDTO implements Serializable {

    private static final long serialVersionUID = 2113315265843739418L;

    private Long id;

    @NotNull
    private Long idEnfermedad;

    private String nombreEnfermedad;

    @NotNull
    private Long idExamen;

    private String nombreExamen;

}
