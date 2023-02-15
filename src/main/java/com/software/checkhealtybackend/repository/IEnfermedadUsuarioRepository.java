package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.EnfermedadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEnfermedadUsuarioRepository extends JpaRepository<EnfermedadUsuario, Long> {


    /**Verifica que NO exista usuario con el username**/
    @Query("SELECT e FROM EnfermedadUsuario e " +
            " WHERE e.usuario.id =:aIdUser " )
    List<EnfermedadUsuario> findByIdUser(Long aIdUser);
}
