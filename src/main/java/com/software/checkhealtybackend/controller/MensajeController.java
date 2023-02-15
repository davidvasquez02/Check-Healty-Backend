package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.MensajeDTO;
import com.software.checkhealtybackend.mappers.MensajeMapper;
import com.software.checkhealtybackend.service.interfaces.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/mensaje")
public class MensajeController {

    private IMensajeService mensajeService;

    @GetMapping("/id/{id}")
    public ResponseEntity<MensajeDTO> findById(@PathVariable(value = "id") Long aId) {
        var mensaje = this.mensajeService.findById(aId);
        return new ResponseEntity<>(MensajeMapper.INSTANCE.toMensajeDTO(mensaje), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> createMensaje(@RequestBody MensajeDTO aMensajeDTO) {
        var mensaje = this.mensajeService.createMensaje(MensajeMapper.INSTANCE.toMensaje(aMensajeDTO));
        return new ResponseEntity<>(MensajeMapper.INSTANCE.toMensajeDTO(mensaje), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MensajeDTO> updateMensaje(@RequestBody MensajeDTO aMensajeDTO) {
        var mensaje = this.mensajeService.updateMensaje(MensajeMapper.INSTANCE.toMensaje(aMensajeDTO));
        return new ResponseEntity<>(MensajeMapper.INSTANCE.toMensajeDTO(mensaje), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteMensaje(@PathVariable(value = "id") Long aId) {
        this.mensajeService.deleteMensaje(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Autowired
    public void setMensajeService(IMensajeService mensajeService){
        this.mensajeService = mensajeService;
    }
}
