package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Long> {

    @Query("SELECT p " +
            "FROM Publicacion p " +
            "WHERE p.idSeccionForo = :idSeccion " +
            "OR p.idUsuario = :idUsuario " +
            "ORDER BY p.fecha desc ")
    List<Publicacion> findAllByIdSeccionOrIdUsuario(Long idSeccion, Long idUsuario);
}
