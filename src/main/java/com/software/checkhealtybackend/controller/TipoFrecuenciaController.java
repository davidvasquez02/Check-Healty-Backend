package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TipoFrecuenciaDTO;
import com.software.checkhealtybackend.mappers.TipoFrecuenciaMapper;
import com.software.checkhealtybackend.service.interfaces.ITipoFrecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tipoFrecuencia")
public class TipoFrecuenciaController {

    private ITipoFrecuenciaService tipoFrecuenciaService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TipoFrecuenciaDTO> findById(@PathVariable(value = "id") Long aId) {
        var tipoFrecuencia = this.tipoFrecuenciaService.findById(aId);
        return new ResponseEntity<>(TipoFrecuenciaMapper.INSTANCE.toTipoFrecuenciaDTO(tipoFrecuencia), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoFrecuenciaDTO> createTipoFrecuencia(@RequestBody TipoFrecuenciaDTO aTipoFrecuenciaDTO) {
        var tipoFrecuencia = this.tipoFrecuenciaService.createTipoFrecuencia(TipoFrecuenciaMapper.INSTANCE.toTipoFrecuencia(aTipoFrecuenciaDTO));
        return new ResponseEntity<>(TipoFrecuenciaMapper.INSTANCE.toTipoFrecuenciaDTO(tipoFrecuencia), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoFrecuenciaDTO> updateTipoFrecuencia(@RequestBody TipoFrecuenciaDTO aTipoFrecuenciaDTO) {
        var tipoFrecuencia = this.tipoFrecuenciaService.updateTipoFrecuencia(TipoFrecuenciaMapper.INSTANCE.toTipoFrecuencia(aTipoFrecuenciaDTO));
        return new ResponseEntity<>(TipoFrecuenciaMapper.INSTANCE.toTipoFrecuenciaDTO(tipoFrecuencia), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTipoFrecuencia(@PathVariable(value = "id") Long aId) {
        this.tipoFrecuenciaService.deleteTipoFrecuencia(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setTipoFrecuenciaService(ITipoFrecuenciaService tipoFrecuenciaService){
        this.tipoFrecuenciaService = tipoFrecuenciaService;
    }
}
