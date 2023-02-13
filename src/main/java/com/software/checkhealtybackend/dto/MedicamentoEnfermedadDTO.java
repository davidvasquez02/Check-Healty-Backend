package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;

import java.io.Serializable;

public class MedicamentoEnfermedadDTO implements Serializable {

    private static final long serialVersionUID = -1009344222853370524L;

    private Long id;

    @NotNull
    private Long idMedicamento;

    @NotNull
    private Long idEnfermedad;

    private String nombreMedicamento;

    private String nombreEnfermedad;

}
