package com.software.checkhealtybackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long idExamenUsuario;

    private Boolean Checkk;

    private Long nroExamen;

    @JsonFormat(pattern = "dd-M-yyyy hh:mm:ss", timezone = "America/Bogota")
    private Date fechaHora;

}
