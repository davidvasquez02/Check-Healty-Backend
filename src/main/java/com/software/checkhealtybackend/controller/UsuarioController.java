package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.UsuarioDTO;
import com.software.checkhealtybackend.mappers.UsuarioMapper;
import com.software.checkhealtybackend.model.Token;
import com.software.checkhealtybackend.repository.ITokenRepository;
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

    @Autowired
    private ITokenRepository tokenRepository;

    @GetMapping("/id")
    public ResponseEntity<UsuarioDTO> findById(@RequestParam(value = "idUsuario") Long aId) {
        var usuario = this.usuarioService.findById(aId);
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO aUsuarioDTO) {
        var usuario = this.usuarioService.createUsuario(aUsuarioDTO);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO aUsuarioDTO) {
        var usuario = this.usuarioService.updateUsuario(UsuarioMapper.INSTANCE.toUsuario(aUsuarioDTO));
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
    }

    @PutMapping("/token")
    public ResponseEntity<Token> token(@RequestBody Token token) {
        Token token1 = tokenRepository.save(token);
        return new ResponseEntity<>(token1, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable(value = "id") Long aId) {
        this.usuarioService.deleteUsuario(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Inicio de sesion
    @GetMapping("/inicioSesion")
    public ResponseEntity<UsuarioDTO> sesionUsuario(@RequestParam(name = "correo") String aCorreo,
                                                    @RequestParam(value = "contraseña") String aContraseña,
                                                    @RequestParam String token) {
        Token token1 = tokenRepository.save(new Token(1,token));
        var valid = this.usuarioService.sesionUsuario(aCorreo,aContraseña);
        return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(valid), HttpStatus.OK);
    }


    @Autowired
    public void setUsuarioService(IUsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
}
