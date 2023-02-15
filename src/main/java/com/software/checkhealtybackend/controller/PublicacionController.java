package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.PublicacionDTO;
import com.software.checkhealtybackend.mappers.PublicacionMapper;
import com.software.checkhealtybackend.service.interfaces.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/publicacion")
public class PublicacionController {

    private IPublicacionService publicacionService;


    @GetMapping("/id/{id}")
    public ResponseEntity<PublicacionDTO> findById(@PathVariable(value = "id") Long aId) {
        var publicacion = this.publicacionService.findById(aId);
        return new ResponseEntity<>(PublicacionMapper.INSTANCE.toPublicacionDTO(publicacion), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PublicacionDTO> createPublicacion(@RequestBody PublicacionDTO aPublicacionDTO) {
        var publicacion = this.publicacionService.createPublicacion(PublicacionMapper.INSTANCE.toPublicacion(aPublicacionDTO));
        return new ResponseEntity<>(PublicacionMapper.INSTANCE.toPublicacionDTO(publicacion), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PublicacionDTO> updatePublicacion(@RequestBody PublicacionDTO aPublicacionDTO) {
        var publicacion = this.publicacionService.updatePublicacion(PublicacionMapper.INSTANCE.toPublicacion(aPublicacionDTO));
        return new ResponseEntity<>(PublicacionMapper.INSTANCE.toPublicacionDTO(publicacion), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deletePublicacion(@PathVariable(value = "id") Long aId) {
        this.publicacionService.deletePublicacion(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setPublicacionService(IPublicacionService publicacionService){
        this.publicacionService = publicacionService;
    }
}
