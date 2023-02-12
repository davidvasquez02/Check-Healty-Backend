package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.EnfermedadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnfermedadUsuarioRepository extends JpaRepository<EnfermedadUsuario, Long> {
}
