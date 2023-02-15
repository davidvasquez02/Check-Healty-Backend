package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.UsuarioDTO;
import com.software.checkhealtybackend.mappers.UsuarioMapper;
import com.software.checkhealtybackend.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {

    private IUsuarioService usuarioService;

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable(value = "id") Long aId) {
        var usuario = this.usuarioService.findById(aId);
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO aUsuarioDTO) {
        var usuario = this.usuarioService.createUsuario(UsuarioMapper.INSTANCE.toUsuario(aUsuarioDTO));
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO aUsuarioDTO) {
        var usuario = this.usuarioService.updateUsuario(UsuarioMapper.INSTANCE.toUsuario(aUsuarioDTO));
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable(value = "id") Long aId) {
        this.usuarioService.deleteUsuario(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inicio de sesion
    @GetMapping("/inicioSesion")
    public ResponseEntity<Long> sesionUsuario(@RequestParam(name = "user") String aUser,
                                                 @RequestParam(value = "contraseña") String aContraseña) {
        return new ResponseEntity<>(this.usuarioService.sesionUsuario(aUser,aContraseña), HttpStatus.OK);
    }


    @Autowired
    public void setUsuarioService(IUsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
}
