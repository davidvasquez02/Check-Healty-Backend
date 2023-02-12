package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.ExamenDTO;
import com.software.checkhealtybackend.mappers.ExamenMapper;
import com.software.checkhealtybackend.service.interfaces.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/examen")
public class ExamenController {

    private IExamenService examenService;


    @GetMapping("/id/{id}")
    public ResponseEntity<ExamenDTO> findById(@PathVariable(value = "id") Long aId) {
        var examen = this.examenService.findById(aId);
        return new ResponseEntity<>(ExamenMapper.INSTANCE.toExamenDTO(examen), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExamenDTO> createExamen(@RequestBody ExamenDTO aExamenDTO) {
        var examen = this.examenService.createExamen(ExamenMapper.INSTANCE.toExamen(aExamenDTO));
        return new ResponseEntity<>(ExamenMapper.INSTANCE.toExamenDTO(examen), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ExamenDTO> updateExamen(@RequestBody ExamenDTO aExamenDTO) {
        var examen = this.examenService.updateExamen(ExamenMapper.INSTANCE.toExamen(aExamenDTO));
        return new ResponseEntity<>(ExamenMapper.INSTANCE.toExamenDTO(examen), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteExamen(@PathVariable(value = "id") Long aId) {
        this.examenService.deleteExamen(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setExamenService(IExamenService examenService){
        this.examenService = examenService;
    }
}
