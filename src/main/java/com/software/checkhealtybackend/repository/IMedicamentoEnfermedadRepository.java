package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.MedicamentoEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentoEnfermedadRepository  extends JpaRepository<MedicamentoEnfermedad, Long> {
}
