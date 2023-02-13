package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.ExamenEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamenEnfermedadRepository extends JpaRepository<ExamenEnfermedad, Long> {
}
