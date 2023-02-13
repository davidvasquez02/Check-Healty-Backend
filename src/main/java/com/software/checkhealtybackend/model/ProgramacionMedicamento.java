package com.software.checkhealtybackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramacionMedicamento {

    private static final long serialVersionUID = 7426313733622189935L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idMedicamentoUsuario", nullable = false)
    private Long idMedicamentoUsuario;

    @Column(name = "idTipoFrecuencia", nullable = false)
    private Long idTipoFrecuencia;

    @Column(name = "idTipoDosis", nullable = false)
    private Long idTipoDosis;

    @Column(name = "dosis")
    private String dosis;

    @Column(name = "frecuencia")
    private String frecuencia;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedicamentoUsuario", insertable = false, updatable = false)
    private MedicamentoUsuario medicamentoUsuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoFrecuencia", insertable = false, updatable = false)
    private TipoFrecuencia tipoFrecuencia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoDosis", insertable = false, updatable = false)
    private TipoDosis tipoDosis;
}
