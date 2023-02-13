package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.TipoMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoMedidaRepository extends JpaRepository<TipoMedida, Long> {
}
