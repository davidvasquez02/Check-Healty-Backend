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
public class DosisMedicamentoDTO implements Serializable {

    private static final long serialVersionUID = -4020864310368361529L;

    private Long id;

    @NotNull
    private Long idMedicamentoUsuario;

    private Long nroDosis;

    private Boolean checkk;

    private Date fechaHora;

}
