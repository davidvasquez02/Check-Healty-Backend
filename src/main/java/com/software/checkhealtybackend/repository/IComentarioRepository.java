package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Long> {
}
