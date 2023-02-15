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
@Table(name = "mensaje", schema = "checkhealthdb")
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 5839585611310610940L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idPublicacion", nullable = false)
    private Long idPublicacion;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha")
    private Date fecha;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPublicacion", insertable = false, updatable = false)
    private Publicacion publicacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
