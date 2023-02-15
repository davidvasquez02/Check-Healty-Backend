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
public class TomaExamenDTO implements Serializable {

    private static final long serialVersionUID = -1589536062299398058L;

    private Long id;

    @NotNull
    private Long idProgramacionExamen;

    private Boolean Checkk;

    private Long nroExamen;

    private Date fechaHora;

}
