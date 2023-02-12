package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.MedicamentoDTO;
import com.software.checkhealtybackend.mappers.MedicamentoMapper;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicamento")
public class MedicamentoController {

    private IMedicamentoService medicamentoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable(value = "id") Long aId) {
        var medicamento = this.medicamentoService.findById(aId);
        return new ResponseEntity<>(MedicamentoMapper.INSTANCE.toMedicamentoDTO(medicamento), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicamentoDTO> createMedicamento(@RequestBody MedicamentoDTO aMedicamentoDTO) {
        var medicamento = this.medicamentoService.createMedicamento(MedicamentoMapper.INSTANCE.toMedicamento(aMedicamentoDTO));
        return new ResponseEntity<>(MedicamentoMapper.INSTANCE.toMedicamentoDTO(medicamento), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MedicamentoDTO> updateMedicamento(@RequestBody MedicamentoDTO aMedicamentoDTO) {
        var medicamento = this.medicamentoService.updateMedicamento(MedicamentoMapper.INSTANCE.toMedicamento(aMedicamentoDTO));
        return new ResponseEntity<>(MedicamentoMapper.INSTANCE.toMedicamentoDTO(medicamento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteMedicamento(@PathVariable(value = "id") Long aId) {
        this.medicamentoService.deleteMedicamento(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Autowired
    public void setMedicamentoService(IMedicamentoService medicamentoService){
        this.medicamentoService = medicamentoService;
    }
}
