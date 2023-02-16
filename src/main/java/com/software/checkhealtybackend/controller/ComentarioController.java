package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.ComentarioDTO;
import com.software.checkhealtybackend.mappers.ComentarioMapper;
import com.software.checkhealtybackend.service.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/mensaje")
public class ComentarioController {

    private IComentarioService mensajeService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ComentarioDTO> findById(@PathVariable(value = "id") Long aId) {
        var mensaje = this.mensajeService.findById(aId);
        return new ResponseEntity<>(ComentarioMapper.INSTANCE.toMensajeDTO(mensaje), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> createMensaje(@RequestBody ComentarioDTO aComentarioDTO) {
        var mensaje = this.mensajeService.createMensaje(ComentarioMapper.INSTANCE.toMensaje(aComentarioDTO));
        return new ResponseEntity<>(ComentarioMapper.INSTANCE.toMensajeDTO(mensaje), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ComentarioDTO> updateMensaje(@RequestBody ComentarioDTO aComentarioDTO) {
        var mensaje = this.mensajeService.updateMensaje(ComentarioMapper.INSTANCE.toMensaje(aComentarioDTO));
        return new ResponseEntity<>(ComentarioMapper.INSTANCE.toMensajeDTO(mensaje), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteMensaje(@PathVariable(value = "id") Long aId) {
        this.mensajeService.deleteMensaje(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Autowired
    public void setMensajeService(IComentarioService mensajeService){
        this.mensajeService = mensajeService;
    }
}
