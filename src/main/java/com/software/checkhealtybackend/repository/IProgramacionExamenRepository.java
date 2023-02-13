package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.ProgramacionExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramacionExamenRepository extends JpaRepository<ProgramacionExamen, Long> {
}