package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.MedicamentoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicamentoUsuarioRepository extends JpaRepository<MedicamentoUsuario, Long> {
    List<MedicamentoUsuario> findByIdEnfermedadUsuario(Long idEnfermedadUsuario);
}

