package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.InformacionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformacionUsuarioRepository extends JpaRepository<InformacionUsuario, Long> {
}