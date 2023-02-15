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
@Table(name = "medicamento_enfermedad", schema = "checkhealthdb")
public class MedicamentoEnfermedad implements Serializable {

    private static final long serialVersionUID = -4574411818745733865L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idMedicamento", nullable = false)
    private Long idMedicamento;

    @Column(name = "idEnfermedad", nullable = false)
    private Long idEnfermedad;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedicamento", insertable = false, updatable = false)
    private Medicamento medicamento;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnfermedad", insertable = false, updatable = false)
    private Enfermedad enfermedad;
}