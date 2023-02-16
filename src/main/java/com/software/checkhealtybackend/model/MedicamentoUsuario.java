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
@Table(name = "medicamento_usuario", schema = "checkhealthdb")
public class MedicamentoUsuario implements Serializable {

    private static final long serialVersionUID = -7559914281691945367L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idEnfermedadUsuario", nullable = false)
    private Long idEnfermedadUsuario;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedadUsuario", insertable = false, updatable = false)
    private EnfermedadUsuario enfermedadUsuario;

    //ProgramacioMedicamento

    @Column(name = "idTipoFrecuencia", nullable = false)
    private Long idTipoFrecuencia;

    @Column(name = "idTipoDosis", nullable = false)
    private Long idTipoDosis;

    @Column(name = "dosis")
    private String dosis;

    @Column(name = "frecuencia")
    private String frecuencia;

    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoFrecuencia", insertable = false, updatable = false)
    private TipoFrecuencia tipoFrecuencia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoDosis", insertable = false, updatable = false)
    private TipoDosis tipoDosis;
}
