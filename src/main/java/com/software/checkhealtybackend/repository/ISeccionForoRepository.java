package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.SeccionForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeccionForoRepository extends JpaRepository<SeccionForo, Long> {
}
