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
}
