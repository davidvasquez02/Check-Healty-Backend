package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.DosisMedicamentoDTO;
import com.software.checkhealtybackend.mappers.DosisMedicamentoMapper;
import com.software.checkhealtybackend.service.interfaces.IDosisMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/dosisMedicamento")
public class DosisMedicamentoController {

    private IDosisMedicamentoService dosisMedicamentoService;


    @GetMapping("/id/{id}")
    public ResponseEntity<DosisMedicamentoDTO> findById(@PathVariable(value = "id") Long aId) {
        var dosisMedicamento = this.dosisMedicamentoService.findById(aId);
        return new ResponseEntity<>(DosisMedicamentoMapper.INSTANCE.toDosisMedicamentoDTO(dosisMedicamento), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DosisMedicamentoDTO> createDosisMedicamento(@RequestBody DosisMedicamentoDTO aDosisMedicamentoDTO) {
        var dosisMedicamento = this.dosisMedicamentoService.createDosisMedicamento(DosisMedicamentoMapper.INSTANCE.toDosisMedicamento(aDosisMedicamentoDTO));
        return new ResponseEntity<>(DosisMedicamentoMapper.INSTANCE.toDosisMedicamentoDTO(dosisMedicamento), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DosisMedicamentoDTO> updateDosisMedicamento(@RequestBody DosisMedicamentoDTO aDosisMedicamentoDTO) {
        var dosisMedicamento = this.dosisMedicamentoService.updateDosisMedicamento(DosisMedicamentoMapper.INSTANCE.toDosisMedicamento(aDosisMedicamentoDTO));
        return new ResponseEntity<>(DosisMedicamentoMapper.INSTANCE.toDosisMedicamentoDTO(dosisMedicamento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteDosisMedicamento(@PathVariable(value = "id") Long aId) {
        this.dosisMedicamentoService.deleteDosisMedicamento(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setDosisMedicamentoService(IDosisMedicamentoService dosisMedicamentoService){
        this.dosisMedicamentoService = dosisMedicamentoService;
    }
}