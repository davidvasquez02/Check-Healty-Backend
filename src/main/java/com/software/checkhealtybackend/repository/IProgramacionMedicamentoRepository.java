package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.ProgramacionMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramacionMedicamentoRepository extends JpaRepository<ProgramacionMedicamento, Long> {
}