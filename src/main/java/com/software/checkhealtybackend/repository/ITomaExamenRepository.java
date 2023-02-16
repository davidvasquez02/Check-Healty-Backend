package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.DosisMedicamento;
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
            " WHERE t.examenUsuario.enfermedadUsuario.usuario.id =:aIdUser " +
            " AND ((t.fechaHora >=:aFechaDesde) OR :aFechaDesde IS NULL) " +
            " AND ((t.fechaHora <=:aFechaHasta) OR :aFechaHasta IS NULL) " +
            " AND ((t.checkk =:aCheckk) OR :aCheckk IS NULL) ")
    List<TomaExamen> findTomaExamenByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheckk);


    /**Trae tomaExamenes segun idUsuario**/
    @Query("SELECT t FROM TomaExamen t " +
            " WHERE  ((t.examenUsuario.enfermedadUsuario.usuario.id =:aIdUser) OR :aIdUser IS NULL) ")
    List<TomaExamen> findTomaExamenByUser(Long aIdUser);

    /**Trae tomaExamenes antes de la fecha actual segun idUsuario**/
    @Query("SELECT t FROM TomaExamen t " +
            " WHERE ((t.examenUsuario.enfermedadUsuario.id =:aIdUser) OR :aIdUser IS NULL) " +
            " AND (t.fechaHora <:date) OR :date IS NULL")
    List<TomaExamen> findAllBeforeCurrentDate(Long aIdUser, Date date);
}