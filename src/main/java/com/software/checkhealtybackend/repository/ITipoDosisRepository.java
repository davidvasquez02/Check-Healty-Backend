package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.TipoDosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDosisRepository extends JpaRepository<TipoDosis, Long> {
}
