package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepository extends JpaRepository<Token,Integer> {
}
