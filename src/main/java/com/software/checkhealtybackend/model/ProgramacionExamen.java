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
public class ProgramacionExamen implements Serializable {

    private static final long serialVersionUID = -3584305763534871043L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idExamenUsuario", nullable = false)
    private Long idExamenUsuario;

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
    @JoinColumn(name = "idExamenUsuario", insertable = false, updatable = false)
    private ExamenUsuario examenUsuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoFrecuencia", insertable = false, updatable = false)
    private TipoFrecuencia tipoFrecuencia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMedida", insertable = false, updatable = false)
    private TipoMedida tipoMedida;
}
