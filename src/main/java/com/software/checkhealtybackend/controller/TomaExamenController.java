package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TomaExamenDTO;
import com.software.checkhealtybackend.mappers.TomaExamenMapper;
import com.software.checkhealtybackend.service.interfaces.ITomaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tomaExamen")
public class TomaExamenController {

    private ITomaExamenService tomaExamenService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TomaExamenDTO> findById(@PathVariable(value = "id") Long aId) {
        var tomaExamen = this.tomaExamenService.findById(aId);
        return new ResponseEntity<>(TomaExamenMapper.INSTANCE.toTomaExamenDTO(tomaExamen), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TomaExamenDTO> createTomaExamen(@RequestBody TomaExamenDTO aTomaExamenDTO) {
        var tomaExamen = this.tomaExamenService.createTomaExamen(TomaExamenMapper.INSTANCE.toTomaExamen(aTomaExamenDTO));
        return new ResponseEntity<>(TomaExamenMapper.INSTANCE.toTomaExamenDTO(tomaExamen), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TomaExamenDTO> updateTomaExamen(@RequestBody TomaExamenDTO aTomaExamenDTO) {
        var tomaExamen = this.tomaExamenService.updateTomaExamen(TomaExamenMapper.INSTANCE.toTomaExamen(aTomaExamenDTO));
        return new ResponseEntity<>(TomaExamenMapper.INSTANCE.toTomaExamenDTO(tomaExamen), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTomaExamen(@PathVariable(value = "id") Long aId) {
        this.tomaExamenService.deleteTomaExamen(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setTomaExamenService(ITomaExamenService tomaExamenService){
        this.tomaExamenService = tomaExamenService;
    }
}
