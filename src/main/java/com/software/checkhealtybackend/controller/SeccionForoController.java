package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.SeccionForoDTO;
import com.software.checkhealtybackend.mappers.SeccionForoMapper;
import com.software.checkhealtybackend.service.interfaces.ISeccionForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    //Obtiene todas las secciones
    @GetMapping("/allSeccion")
    public ResponseEntity<List<SeccionForoDTO>> getAll() {
        return new ResponseEntity<>(this.seccionForoService.getAll().stream()
                .map(SeccionForoMapper.INSTANCE::toSeccionForoDTO).collect(Collectors.toList()), HttpStatus.OK);
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

