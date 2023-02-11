package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.EnfermedadDTO;
import com.software.checkhealtybackend.mappers.EnfermedadMapper;
import com.software.checkhealtybackend.service.interfaces.IEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enfermedad")
public class EnfermedadController {

    private IEnfermedadService enfermedadService;


    @GetMapping("/id/{id}")
    public ResponseEntity<EnfermedadDTO> findById(@PathVariable(value = "id") Long aId) {
        var usuario = this.enfermedadService.findById(aId);
        return new ResponseEntity<>(EnfermedadMapper.INSTANCE.toEnfermedadDTO(usuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnfermedadDTO> createEnfermedad(@RequestBody EnfermedadDTO aEnfermedadDTO) {
        var enfermedad = this.enfermedadService.createEnfermedad(EnfermedadMapper.INSTANCE.toEnfermedad(aEnfermedadDTO));
        return new ResponseEntity<>(EnfermedadMapper.INSTANCE.toEnfermedadDTO(enfermedad), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EnfermedadDTO> updateUsuario(@RequestBody EnfermedadDTO aEnfermedadDTO) {
        var enfermedad = this.enfermedadService.updateEnfermedad(EnfermedadMapper.INSTANCE.toEnfermedad(aEnfermedadDTO));
        return new ResponseEntity<>(EnfermedadMapper.INSTANCE.toEnfermedadDTO(enfermedad), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable(value = "id") Long aId) {
        this.enfermedadService.deleteEnfermedad(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setEnfermedadService(IEnfermedadService enfermedadService){
        this.enfermedadService = enfermedadService;
    }
}
