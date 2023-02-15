package com.software.checkhealtybackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enfermedad_usuario", schema = "checkhealthdb")
public class EnfermedadUsuario implements Serializable {

    private static final long serialVersionUID = -155748995665269517L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "idEnfermedad", nullable = false)
    private Long idEnfermedad;

    @Column(name = "padece")
    private Long padece;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedad", insertable = false, updatable = false)
    private Enfermedad enfermedad;

}
