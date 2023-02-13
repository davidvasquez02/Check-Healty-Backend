package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.DosisMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDosisMedicamentoRepository  extends JpaRepository<DosisMedicamento, Long> {
}
