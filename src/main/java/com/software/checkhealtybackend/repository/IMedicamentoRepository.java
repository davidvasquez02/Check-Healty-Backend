package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
