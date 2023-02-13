package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.ExamenUsuarioDTO;
import com.software.checkhealtybackend.mappers.ExamenUsuarioMapper;
import com.software.checkhealtybackend.service.interfaces.IExamenUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/examenUsuario")
public class ExamenUsuarioController {

    private IExamenUsuarioService examenUsuarioService;


    @GetMapping("/id/{id}")
    public ResponseEntity<ExamenUsuarioDTO> findById(@PathVariable(value = "id") Long aId) {
        var examenUsuario = this.examenUsuarioService.findById(aId);
        return new ResponseEntity<>(ExamenUsuarioMapper.INSTANCE.toExamenUsuarioDTO(examenUsuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExamenUsuarioDTO> createExamenUsuario(@RequestBody ExamenUsuarioDTO aExamenUsuarioDTO) {
        var examen = this.examenUsuarioService.createExamenUsuario(ExamenUsuarioMapper.INSTANCE.toExamenUsuario(aExamenUsuarioDTO));
        return new ResponseEntity<>(ExamenUsuarioMapper.INSTANCE.toExamenUsuarioDTO(examen), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExamenUsuarioDTO> updateExamenUsuario(@RequestBody ExamenUsuarioDTO aExamenUsuarioDTO) {
        var examen = this.examenUsuarioService.updateExamenUsuario(ExamenUsuarioMapper.INSTANCE.toExamenUsuario(aExamenUsuarioDTO));
        return new ResponseEntity<>(ExamenUsuarioMapper.INSTANCE.toExamenUsuarioDTO(examen), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteExamenUsuario(@PathVariable(value = "id") Long aId) {
        this.examenUsuarioService.deleteExamenUsuario(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setExamenUsuarioService(IExamenUsuarioService examenUsuarioService){
        this.examenUsuarioService = examenUsuarioService;
    }
}