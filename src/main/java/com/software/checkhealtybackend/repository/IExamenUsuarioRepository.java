package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.ExamenUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExamenUsuarioRepository extends JpaRepository<ExamenUsuario, Long> {
    List<ExamenUsuario> findByIdEnfermedadUsuario(Long idEnfermedadUsuario);
}
