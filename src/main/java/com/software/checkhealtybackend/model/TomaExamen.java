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
public class TomaExamen implements Serializable {

    private static final long serialVersionUID = -8411754817615693125L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Checkk")
    private Boolean checkk;

    @Column(name = "fechaHora")
    private Date fechaHora;

    @Column(name = "nroExamen")
    private Long nroExamen;

    @Column(name = "idProgramacionExamen", nullable = false)
    private Long idProgramacionExamen;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProgramacionExamen", insertable = false, updatable = false)
    private ProgramacionExamen programacionExamen;

}