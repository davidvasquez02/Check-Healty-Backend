package com.software.checkhealtybackend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DosisMedicamentoDTO {

    private static final long serialVersionUID = -4020864310368361529L;

    private Long id;

    @NotNull
    private Long idProgramacionMedicamento;

    private Long nroDosis;

    private Long checkk;

    private Date fechaHora;

}
