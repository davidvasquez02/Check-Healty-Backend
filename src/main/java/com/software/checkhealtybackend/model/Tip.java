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
@Table(name = "tips", schema = "checkhealthdb")
public class Tip implements Serializable {

    private static final long serialVersionUID = 7699344080470959586L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idEnfermedad")
    private Long idEnfermedad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedad", insertable = false, updatable = false)
    private Enfermedad enfermedad;
}
