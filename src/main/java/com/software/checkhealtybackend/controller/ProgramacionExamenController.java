package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.ProgramacionExamenDTO;
import com.software.checkhealtybackend.mappers.ProgramacionExamenMapper;
import com.software.checkhealtybackend.service.interfaces.IProgramacionExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/programacionExamen")
public class ProgramacionExamenController {

    private IProgramacionExamenService programacionExamenService;


    @GetMapping("/id/{id}")
    public ResponseEntity<ProgramacionExamenDTO> findById(@PathVariable(value = "id") Long aId) {
        var programacionExamen = this.programacionExamenService.findById(aId);
        return new ResponseEntity<>(ProgramacionExamenMapper.INSTANCE.toProgramacionExamenDTO(programacionExamen), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramacionExamenDTO> createProgramacionExamen(@RequestBody ProgramacionExamenDTO aProgramacionExamenDTO) {
        var programacionExamen = this.programacionExamenService.createProgramacionExamen(ProgramacionExamenMapper.INSTANCE.toProgramacionExamen(aProgramacionExamenDTO));
        return new ResponseEntity<>(ProgramacionExamenMapper.INSTANCE.toProgramacionExamenDTO(programacionExamen), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProgramacionExamenDTO> updateProgramacionExamen(@RequestBody ProgramacionExamenDTO aProgramacionExamenDTO) {
        var programacionExamen = this.programacionExamenService.updateProgramacionExamen(ProgramacionExamenMapper.INSTANCE.toProgramacionExamen(aProgramacionExamenDTO));
        return new ResponseEntity<>(ProgramacionExamenMapper.INSTANCE.toProgramacionExamenDTO(programacionExamen), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteProgramacionExamen(@PathVariable(value = "id") Long aId) {
        this.programacionExamenService.deleteProgramacionExamen(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setProgramacionExamenService(IProgramacionExamenService programacionExamenService){
        this.programacionExamenService = programacionExamenService;
    }
}

