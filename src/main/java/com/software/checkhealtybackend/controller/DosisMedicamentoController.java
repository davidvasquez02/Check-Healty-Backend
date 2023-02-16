package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.DosisMedicamentoDTO;
import com.software.checkhealtybackend.dto.DosisMedicamentoDTO;
import com.software.checkhealtybackend.mappers.DosisMedicamentoMapper;
import com.software.checkhealtybackend.mappers.DosisMedicamentoMapper;
import com.software.checkhealtybackend.service.interfaces.IDosisMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    //DosisMedicamento realizadas
    @GetMapping("/dosisMedicamentoRealizadas")
    public ResponseEntity <List<DosisMedicamentoDTO>> findDosisMedicamentoByCheck(@RequestParam(name = "idUsuario") Long User,
                                                                      @RequestParam(name = "fechaDesde", required = false) Date aFechaDesde,
                                                                      @RequestParam(name = "fechaHasta", required = false) Date aFechaHasta,
                                                                      @RequestParam(name = "checkk", required = false) Boolean aCheck) {
        var listaDosisMedicamento = this.dosisMedicamentoService.findDosisMedicamentoByCheck(User, aFechaDesde, aFechaHasta, aCheck);
        return new ResponseEntity<>(listaDosisMedicamento.stream().map(DosisMedicamentoMapper.INSTANCE::toDosisMedicamentoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }



    //Estadisticas
    @GetMapping("/estadisticas")
    public ResponseEntity  <List<List<List<String>>>> findEstadisticaByIdUser(@RequestParam(name = "idUser", required = false) Long aIdUser) {
        var listEstadistica = this.dosisMedicamentoService.findEstadistica(aIdUser);
        return new ResponseEntity<>(listEstadistica, HttpStatus.OK);
    }


    //DosisMedicamento según idUsuario
    @GetMapping("/all")
    public ResponseEntity <List<DosisMedicamentoDTO>> findAllByIdUser(@RequestParam(name = "idUser", required = false) Long aIdUser) {
        var listDosisMedicamento = this.dosisMedicamentoService.findAllByUser(aIdUser);
        return new ResponseEntity<>(listDosisMedicamento.stream().map(DosisMedicamentoMapper.INSTANCE::toDosisMedicamentoDTO).collect(Collectors.toList()), HttpStatus.OK);
    }


    @Autowired
    public void setDosisMedicamentoService(IDosisMedicamentoService dosisMedicamentoService){
        this.dosisMedicamentoService = dosisMedicamentoService;
    }
}