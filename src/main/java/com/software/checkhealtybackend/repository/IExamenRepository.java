package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExamenRepository extends JpaRepository<Examen, Long> {

    @Query("SELECT e FROM Examen e LEFT JOIN ExamenUsuario u on e.id=u.enfermedadUsuario.id " +
            "WHERE u.enfermedadUsuario.usuario.id =:aUser " )
    List<Examen> allByUser(Long aUser);
}
