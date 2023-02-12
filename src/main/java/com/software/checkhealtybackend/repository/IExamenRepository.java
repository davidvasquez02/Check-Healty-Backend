package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamenRepository extends JpaRepository<Examen, Long> {
}
