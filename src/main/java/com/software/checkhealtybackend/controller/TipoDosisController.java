package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TipoDosisDTO;
import com.software.checkhealtybackend.dto.TipoDosisDTO;
import com.software.checkhealtybackend.mappers.TipoDosisMapper;
import com.software.checkhealtybackend.mappers.TipoDosisMapper;
import com.software.checkhealtybackend.service.interfaces.ITipoDosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tipoDosis")
public class TipoDosisController {

    private ITipoDosisService tipoDosisService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TipoDosisDTO> findById(@PathVariable(value = "id") Long aId) {
        var tipoDosis = this.tipoDosisService.findById(aId);
        return new ResponseEntity<>(TipoDosisMapper.INSTANCE.toTipoDosisDTO(tipoDosis), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoDosisDTO> createTipoDosis(@RequestBody TipoDosisDTO aTipoDosisDTO) {
        var tipoDosis = this.tipoDosisService.createTipoDosis(TipoDosisMapper.INSTANCE.toTipoDosis(aTipoDosisDTO));
        return new ResponseEntity<>(TipoDosisMapper.INSTANCE.toTipoDosisDTO(tipoDosis), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoDosisDTO> updateTipoDosis(@RequestBody TipoDosisDTO aTipoDosisDTO) {
        var tipoDosis = this.tipoDosisService.updateTipoDosis(TipoDosisMapper.INSTANCE.toTipoDosis(aTipoDosisDTO));
        return new ResponseEntity<>(TipoDosisMapper.INSTANCE.toTipoDosisDTO(tipoDosis), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTipoDosis(@PathVariable(value = "id") Long aId) {
        this.tipoDosisService.deleteTipoDosis(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Lista all TipoDosis
    @GetMapping("/all")
    public ResponseEntity <List<TipoDosisDTO>> findByIdUser() {
        var listTipoDosis = this.tipoDosisService.findAll();
        return new ResponseEntity<>(listTipoDosis.stream().map(TipoDosisMapper.INSTANCE::toTipoDosisDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Autowired
    public void setTipoDosisService(ITipoDosisService tipoDosisService){
        this.tipoDosisService = tipoDosisService;
    }
}
