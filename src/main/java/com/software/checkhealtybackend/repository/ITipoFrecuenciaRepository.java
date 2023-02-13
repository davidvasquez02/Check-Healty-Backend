package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.TipoFrecuencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoFrecuenciaRepository  extends JpaRepository<TipoFrecuencia, Long> {
}
