package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.ProgramacionMedicamentoDTO;
import com.software.checkhealtybackend.mappers.ProgramacionMedicamentoMapper;
import com.software.checkhealtybackend.service.interfaces.IProgramacionMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/programacionMedicamento")
public class ProgramacionMedicamentoController {

    private IProgramacionMedicamentoService programacionMedicamentoService;


    @GetMapping("/id/{id}")
    public ResponseEntity<ProgramacionMedicamentoDTO> findById(@PathVariable(value = "id") Long aId) {
        var programacionMedicamento = this.programacionMedicamentoService.findById(aId);
        return new ResponseEntity<>(ProgramacionMedicamentoMapper.INSTANCE.toProgramacionMedicamentoDTO(programacionMedicamento), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramacionMedicamentoDTO> createProgramacionMedicamento(@RequestBody ProgramacionMedicamentoDTO aProgramacionMedicamentoDTO) {
        var programacionMedicamento = this.programacionMedicamentoService.createProgramacionMedicamento(ProgramacionMedicamentoMapper.INSTANCE.toProgramacionMedicamento(aProgramacionMedicamentoDTO));
        return new ResponseEntity<>(ProgramacionMedicamentoMapper.INSTANCE.toProgramacionMedicamentoDTO(programacionMedicamento), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProgramacionMedicamentoDTO> updateProgramacionMedicamento(@RequestBody ProgramacionMedicamentoDTO aProgramacionMedicamentoDTO) {
        var programacionMedicamento = this.programacionMedicamentoService.updateProgramacionMedicamento(ProgramacionMedicamentoMapper.INSTANCE.toProgramacionMedicamento(aProgramacionMedicamentoDTO));
        return new ResponseEntity<>(ProgramacionMedicamentoMapper.INSTANCE.toProgramacionMedicamentoDTO(programacionMedicamento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteProgramacionMedicamento(@PathVariable(value = "id") Long aId) {
        this.programacionMedicamentoService.deleteProgramacionMedicamento(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setProgramacionMedicamentoService(IProgramacionMedicamentoService programacionMedicamentoService){
        this.programacionMedicamentoService = programacionMedicamentoService;
    }
}
