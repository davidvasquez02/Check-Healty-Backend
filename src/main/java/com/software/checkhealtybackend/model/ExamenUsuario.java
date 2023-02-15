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
@Table(name = "examen_usuario", schema = "checkhealthdb")
public class ExamenUsuario implements Serializable {

    private static final long serialVersionUID = -6654667925134342260L;

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "idEnfermedadUsuario", nullable = false)
    private Long idEnfermedadUsuario;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedadUsuario", insertable = false, updatable = false)
    private EnfermedadUsuario enfermedadUsuario;

    //Programacion Examen

    @Column(name = "idTipoFrecuencia", nullable = false)
    private Long idTipoFrecuencia;

    @Column(name = "idTipoMedida", nullable = false)
    private Long idTipoMedida;

    @Column(name = "frecuencia")
    private String frecuencia;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "medidaMin")
    private String medidaMin;

    @Column(name = "medidaMax")
    private String medidaMax;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoFrecuencia", insertable = false, updatable = false)
    private TipoFrecuencia tipoFrecuencia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMedida", insertable = false, updatable = false)
    private TipoMedida tipoMedida;

}
