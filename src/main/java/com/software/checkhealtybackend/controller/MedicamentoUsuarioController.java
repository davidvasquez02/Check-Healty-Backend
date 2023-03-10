package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.MedicamentoUsuarioDTO;
import com.software.checkhealtybackend.mappers.MedicamentoUsuarioMapper;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicamentoUsuario")
public class MedicamentoUsuarioController {

    private IMedicamentoUsuarioService medicamentoUsuarioService;


        @GetMapping("/id")
        public ResponseEntity<List<MedicamentoUsuarioDTO>> findById(@RequestParam(value = "idEnfermedadUsuario") Long aId) {
            var medicamentoUsuario = this.medicamentoUsuarioService.findById(aId);
            return new ResponseEntity<>(medicamentoUsuario.stream().map(MedicamentoUsuarioMapper.INSTANCE::toMedicamentoUsuarioDTO).collect(Collectors.toList()), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<MedicamentoUsuarioDTO> createMedicamentoUsuario(@RequestBody MedicamentoUsuarioDTO aMedicamentoUsuarioDTO) {
            var medicamento = this.medicamentoUsuarioService.createMedicamentoUsuario(MedicamentoUsuarioMapper.INSTANCE.toMedicamentoUsuario(aMedicamentoUsuarioDTO));
            return new ResponseEntity<>(MedicamentoUsuarioMapper.INSTANCE.toMedicamentoUsuarioDTO(medicamento), HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<MedicamentoUsuarioDTO> updateMedicamentoUsuario(@RequestBody MedicamentoUsuarioDTO aMedicamentoUsuarioDTO) {
            var medicamento = this.medicamentoUsuarioService.updateMedicamentoUsuario(MedicamentoUsuarioMapper.INSTANCE.toMedicamentoUsuario(aMedicamentoUsuarioDTO));
            return new ResponseEntity<>(MedicamentoUsuarioMapper.INSTANCE.toMedicamentoUsuarioDTO(medicamento), HttpStatus.OK);
        }

        @DeleteMapping("/id/{id}")
        public ResponseEntity<Boolean> deleteMedicamentoUsuario(@PathVariable(value = "id") Long aId) {
            this.medicamentoUsuarioService.deleteMedicamentoUsuario(aId);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }


        @Autowired
        public void setMedicamentoUsuarioService(IMedicamentoUsuarioService medicamentoUsuarioService){
            this.medicamentoUsuarioService = medicamentoUsuarioService;
        }
}