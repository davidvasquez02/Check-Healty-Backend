package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TipoMedidaDTO;
import com.software.checkhealtybackend.mappers.TipoMedidaMapper;
import com.software.checkhealtybackend.service.interfaces.ITipoMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tipoMedida")
public class TipoMedidaController {

    private ITipoMedidaService tipoMedidaService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TipoMedidaDTO> findById(@PathVariable(value = "id") Long aId) {
        var tipoMedida = this.tipoMedidaService.findById(aId);
        return new ResponseEntity<>(TipoMedidaMapper.INSTANCE.toTipoMedidaDTO(tipoMedida), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoMedidaDTO> createTipoMedida(@RequestBody TipoMedidaDTO aTipoMedidaDTO) {
        var tipoMedida = this.tipoMedidaService.createTipoMedida(TipoMedidaMapper.INSTANCE.toTipoMedida(aTipoMedidaDTO));
        return new ResponseEntity<>(TipoMedidaMapper.INSTANCE.toTipoMedidaDTO(tipoMedida), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipoMedidaDTO> updateTipoMedida(@RequestBody TipoMedidaDTO aTipoMedidaDTO) {
        var tipoMedida = this.tipoMedidaService.updateTipoMedida(TipoMedidaMapper.INSTANCE.toTipoMedida(aTipoMedidaDTO));
        return new ResponseEntity<>(TipoMedidaMapper.INSTANCE.toTipoMedidaDTO(tipoMedida), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTipoMedida(@PathVariable(value = "id") Long aId) {
        this.tipoMedidaService.deleteTipoMedida(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setTipoMedidaService(ITipoMedidaService tipoMedidaService){
        this.tipoMedidaService = tipoMedidaService;
    }
}
