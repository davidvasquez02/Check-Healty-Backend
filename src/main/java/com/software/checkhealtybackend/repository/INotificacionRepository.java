package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Long> {
}
