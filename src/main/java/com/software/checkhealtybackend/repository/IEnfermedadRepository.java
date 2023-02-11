package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnfermedadRepository  extends JpaRepository<Enfermedad, Long> {
}
