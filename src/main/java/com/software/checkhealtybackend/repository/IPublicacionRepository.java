package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Long> {
}
