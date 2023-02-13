package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.MedicamentoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentoUsuarioRepository extends JpaRepository<MedicamentoUsuario, Long> {
}

