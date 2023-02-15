package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.SeccionForoDTO;
import com.software.checkhealtybackend.mappers.SeccionForoMapper;
import com.software.checkhealtybackend.service.interfaces.ISeccionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/seccionForo")
public class SeccionForoController {

    private ISeccionForoService seccionForoService;


    @GetMapping("/id/{id}")
    public ResponseEntity<SeccionForoDTO> findById(@PathVariable(value = "id") Long aId) {
        var seccionForo = this.seccionForoService.findById(aId);
        return new ResponseEntity<>(SeccionForoMapper.INSTANCE.toSeccionForoDTO(seccionForo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SeccionForoDTO> createSeccionForo(@RequestBody SeccionForoDTO aSeccionForoDTO) {
        var seccionForo = this.seccionForoService.createSeccionForo(SeccionForoMapper.INSTANCE.toSeccionForo(aSeccionForoDTO));
        return new ResponseEntity<>(SeccionForoMapper.INSTANCE.toSeccionForoDTO(seccionForo), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SeccionForoDTO> updateSeccionForo(@RequestBody SeccionForoDTO aSeccionForoDTO) {
        var seccionForo = this.seccionForoService.updateSeccionForo(SeccionForoMapper.INSTANCE.toSeccionForo(aSeccionForoDTO));
        return new ResponseEntity<>(SeccionForoMapper.INSTANCE.toSeccionForoDTO(seccionForo), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteSeccionForo(@PathVariable(value = "id") Long aId) {
        this.seccionForoService.deleteSeccionForo(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setSeccionForoService(ISeccionForoService seccionForoService){
        this.seccionForoService = seccionForoService;
    }
}

