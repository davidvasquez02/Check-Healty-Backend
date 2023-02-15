package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TopicoDTO;
import com.software.checkhealtybackend.mappers.TopicoMapper;
import com.software.checkhealtybackend.service.interfaces.ITopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/topico")
public class TopicoController {

    private ITopicoService topicoService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TopicoDTO> findById(@PathVariable(value = "id") Long aId) {
        var topico = this.topicoService.findById(aId);
        return new ResponseEntity<>(TopicoMapper.INSTANCE.toTopicoDTO(topico), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> createTopico(@RequestBody TopicoDTO aTopicoDTO) {
        var topico = this.topicoService.createTopico(TopicoMapper.INSTANCE.toTopico(aTopicoDTO));
        return new ResponseEntity<>(TopicoMapper.INSTANCE.toTopicoDTO(topico), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TopicoDTO> updateTopico(@RequestBody TopicoDTO aTopicoDTO) {
        var topico = this.topicoService.updateTopico(TopicoMapper.INSTANCE.toTopico(aTopicoDTO));
        return new ResponseEntity<>(TopicoMapper.INSTANCE.toTopicoDTO(topico), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTopico(@PathVariable(value = "id") Long aId) {
        this.topicoService.deleteTopico(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setTopicoService(ITopicoService topicoService){
        this.topicoService = topicoService;
    }
}
