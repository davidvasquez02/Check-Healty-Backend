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
@Table(name = "examen_enfermedad", schema = "checkhealthdb")
public class ExamenEnfermedad implements Serializable {

    private static final long serialVersionUID = -6654667925134342260L;

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idEnfermedad", nullable = false)
    private Long idEnfermedad;

    @Column(name = "idExamen", nullable = false)
    private Long idExamen;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedad", insertable = false, updatable = false)
    private Enfermedad enfermedad;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idExamen", insertable = false, updatable = false)
    private Examen examen;

}

