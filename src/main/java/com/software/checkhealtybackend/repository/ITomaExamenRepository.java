package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.TomaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITomaExamenRepository extends JpaRepository<TomaExamen, Long> {
}