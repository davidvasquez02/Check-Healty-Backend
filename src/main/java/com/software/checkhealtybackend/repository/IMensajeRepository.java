package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensaje, Long> {
}
