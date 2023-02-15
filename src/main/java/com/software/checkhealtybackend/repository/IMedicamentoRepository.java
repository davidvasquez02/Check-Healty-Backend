package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Examen;
import com.software.checkhealtybackend.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Long> {

    @Query("SELECT e FROM Medicamento e LEFT JOIN MedicamentoUsuario u on e.id=u.enfermedadUsuario.usuario.id " +
            "WHERE u.enfermedadUsuario.usuario.id =:aUser " )
    List<Medicamento> allByUser(Long aUser);

}
