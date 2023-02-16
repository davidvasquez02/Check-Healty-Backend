package com.software.checkhealtybackend.repository;

import com.software.checkhealtybackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    /**Verifica que exista usuario con el username y contraseña solicitada**/
    @Query("SELECT u FROM Usuario u " +
            " WHERE u.contrasena =:aContraseña " +
            " AND u.correo =:aCorreo ")
    Usuario sesionUsuario(String aCorreo, String aContraseña);


    /**Verifica que NO exista usuario con el username**/
    @Query("SELECT u FROM Usuario u " +
            " WHERE u.correo =:aUser " )
    List<Usuario>usuarioSimilar(String aUser);

}
