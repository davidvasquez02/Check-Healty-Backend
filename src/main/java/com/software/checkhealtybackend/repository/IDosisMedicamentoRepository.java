package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.model.DosisMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IDosisMedicamentoRepository  extends JpaRepository<DosisMedicamento, Long> {

    /**Trae DosisMedicamento Cumplidos o No cumplidos**/
    @Query("SELECT t FROM DosisMedicamento t " +
            " WHERE t.medicamentoUsuario.enfermedadUsuario.usuario.id =:aIdUser " +
            " AND ((t.fechaHora >=:aFechaDesde) OR :aFechaDesde IS NULL) " +
            " AND ((t.fechaHora <=:aFechaHasta) OR :aFechaHasta IS NULL) " +
            " AND ((t.checkk =:aCheckk) OR :aCheckk IS NULL) ")
    List<DosisMedicamento> findDosisMedicamentoByCheck(Long aIdUser, Date aFechaDesde, Date aFechaHasta, Boolean aCheckk);


    /**Trae DosisMedicamento segun idUsuario**/
    @Query("SELECT t FROM DosisMedicamento t " +
            " WHERE  ((t.medicamentoUsuario.enfermedadUsuario.usuario.id =:aIdUser) OR :aIdUser IS NULL) ")
    List<DosisMedicamento> findDosisMedicamentoByUser(Long aIdUser);
}
