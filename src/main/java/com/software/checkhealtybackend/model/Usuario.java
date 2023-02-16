package com.software.checkhealtybackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", schema = "checkhealthdb")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 7699344080470959586L;

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    @Column(name = "Img")
    private String img;

}
