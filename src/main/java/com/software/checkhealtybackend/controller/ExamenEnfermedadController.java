package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.ExamenEnfermedadDTO;
import com.software.checkhealtybackend.mappers.ExamenEnfermedadMapper;
import com.software.checkhealtybackend.service.interfaces.IExamenEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/examenEnfermedad")
public class ExamenEnfermedadController {

    private IExamenEnfermedadService examenEnfermedadService;


    @GetMapping("/id/{id}")
    public ResponseEntity<ExamenEnfermedadDTO> findById(@PathVariable(value = "id") Long aId) {
        var examenEnfermedad = this.examenEnfermedadService.findById(aId);
        return new ResponseEntity<>(ExamenEnfermedadMapper.INSTANCE.toExamenEnfermedadDTO(examenEnfermedad), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExamenEnfermedadDTO> createExamenEnfermedad(@RequestBody ExamenEnfermedadDTO aExamenEnfermedadDTO) {
        var examen = this.examenEnfermedadService.createExamenEnfermedad(ExamenEnfermedadMapper.INSTANCE.toExamenEnfermedad(aExamenEnfermedadDTO));
        return new ResponseEntity<>(ExamenEnfermedadMapper.INSTANCE.toExamenEnfermedadDTO(examen), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExamenEnfermedadDTO> updateExamenEnfermedad(@RequestBody ExamenEnfermedadDTO aExamenEnfermedadDTO) {
        var examen = this.examenEnfermedadService.updateExamenEnfermedad(ExamenEnfermedadMapper.INSTANCE.toExamenEnfermedad(aExamenEnfermedadDTO));
        return new ResponseEntity<>(ExamenEnfermedadMapper.INSTANCE.toExamenEnfermedadDTO(examen), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteExamenEnfermedad(@PathVariable(value = "id") Long aId) {
        this.examenEnfermedadService.deleteExamenEnfermedad(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setExamenEnfermedadService(IExamenEnfermedadService examenEnfermedadService){
        this.examenEnfermedadService = examenEnfermedadService;
    }
}