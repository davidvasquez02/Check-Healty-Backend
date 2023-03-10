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
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 7063908162015284504L;

    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String correo;
    @NotNull
    private String contrasena;
    private String img;

    //Informacion Usuario
    private String alturaMt;
    private String pesoKg;
    private Date fechaNacimiento;

    //Informacion EnfermedadesUsuario
    private Boolean diabetes;
    private Boolean hipertension;
    private Boolean asma;

}
