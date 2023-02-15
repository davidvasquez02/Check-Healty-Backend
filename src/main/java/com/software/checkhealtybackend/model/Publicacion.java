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
@Table(name = "publicacion", schema = "checkhealthdb")
public class Publicacion implements Serializable {

    private static final long serialVersionUID = 5584865421051516335L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idSeccionForo", nullable = false)
    private Long idSeccionForo;

    @Column(name = "idUsuario", nullable = false)
    private Long idUsuario;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSeccionForo", insertable = false, updatable = false)
    private SeccionForo seccionForo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;
}
