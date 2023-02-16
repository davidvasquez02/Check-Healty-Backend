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
@Table(name = "dosis_medicamento", schema = "checkhealthdb")
public class DosisMedicamento implements Serializable {

    private static final long serialVersionUID = -4311064872711568128L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idMedicamentoUsuario", nullable = false)
    private Long idMedicamentoUsuario;

    @Column(name = "nroDosis")
    private Long nroDosis;

    @Column(name = "checkk")
    private Boolean checkk;

    @Column(name = "fechaHora")
    private Date fechaHora;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedicamentoUsuario", insertable = false, updatable = false)
    private MedicamentoUsuario medicamentoUsuario;
}
