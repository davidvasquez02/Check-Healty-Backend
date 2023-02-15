package com.software.checkhealtybackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informacion_usuario", schema = "checkhealthdb")
public class InformacionUsuario implements Serializable {

    private static final long serialVersionUID = 2910707941688707910L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "alturaMt")
    private String alturaMt;

    @Column(name = "pesoKg")
    private String pesoKg;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
