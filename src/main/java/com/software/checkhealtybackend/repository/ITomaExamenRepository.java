package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.TomaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ITomaExamenRepository extends JpaRepository<TomaExamen, Long> {



    /**Trae tomaExamenes Cumplidos o No cumplidos**/
    @Query("SELECT t FROM TomaExamen t " +
            " WHERE t.programacionExamen.examenUsuario.enfermedadUsuario.usuario.id =:aIdUser " +
            " AND ((t.fechaHora >=:aFechaDesde) OR :aFechaDesde IS NULL) " +
            " AND ((t.fechaHora <=:aFechaHasta) OR :aFechaHasta IS NULL) " +
            " AND ((t.checkk =:aCheckk) OR :aCheckk IS NULL) ")
    List<TomaExamen> findTomaExamenByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheckk);


    /**Trae tomaExamenes segun idUsuario**/
    @Query("SELECT t FROM TomaExamen t " +
            " WHERE  ((t.programacionExamen.examenUsuario.enfermedadUsuario.usuario.id =:aIdUser) OR :aIdUser IS NULL) ")
    List<TomaExamen> findTomaExamenByUser(Long aIdUser);
}