package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.MedicamentoEnfermedadDTO;
import com.software.checkhealtybackend.mappers.MedicamentoEnfermedadMapper;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoEnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicamentoEnfermedad")
public class MedicamentoEnfermedadController {

    private IMedicamentoEnfermedadService medicamentoEnfermedadService;


    @GetMapping("/id/{id}")
    public ResponseEntity<MedicamentoEnfermedadDTO> findById(@PathVariable(value = "id") Long aId) {
        var medicamentoEnfermedad = this.medicamentoEnfermedadService.findById(aId);
        return new ResponseEntity<>(MedicamentoEnfermedadMapper.INSTANCE.toMedicamentoEnfermedadDTO(medicamentoEnfermedad), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicamentoEnfermedadDTO> createMedicamentoEnfermedad(@RequestBody MedicamentoEnfermedadDTO aMedicamentoEnfermedadDTO) {
        var medicamento = this.medicamentoEnfermedadService.createMedicamentoEnfermedad(MedicamentoEnfermedadMapper.INSTANCE.toMedicamentoEnfermedad(aMedicamentoEnfermedadDTO));
        return new ResponseEntity<>(MedicamentoEnfermedadMapper.INSTANCE.toMedicamentoEnfermedadDTO(medicamento), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MedicamentoEnfermedadDTO> updateMedicamentoEnfermedad(@RequestBody MedicamentoEnfermedadDTO aMedicamentoEnfermedadDTO) {
        var medicamento = this.medicamentoEnfermedadService.updateMedicamentoEnfermedad(MedicamentoEnfermedadMapper.INSTANCE.toMedicamentoEnfermedad(aMedicamentoEnfermedadDTO));
        return new ResponseEntity<>(MedicamentoEnfermedadMapper.INSTANCE.toMedicamentoEnfermedadDTO(medicamento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteMedicamentoEnfermedad(@PathVariable(value = "id") Long aId) {
        this.medicamentoEnfermedadService.deleteMedicamentoEnfermedad(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setMedicamentoEnfermedadService(IMedicamentoEnfermedadService medicamentoEnfermedadService){
        this.medicamentoEnfermedadService = medicamentoEnfermedadService;
    }
}