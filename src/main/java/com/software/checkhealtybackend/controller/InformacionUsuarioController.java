package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.InformacionUsuarioDTO;
import com.software.checkhealtybackend.mappers.InformacionUsuarioMapper;
import com.software.checkhealtybackend.service.interfaces.IInformacionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/informacionUsuario")
public class InformacionUsuarioController {

    private IInformacionUsuarioService informacionUsuarioService;


    @GetMapping("/id/{id}")
    public ResponseEntity<InformacionUsuarioDTO> findById(@PathVariable(value = "id") Long aId) {
        var informacionUsuario = this.informacionUsuarioService.findById(aId);
        return new ResponseEntity<>(InformacionUsuarioMapper.INSTANCE.toInformacionUsuarioDTO(informacionUsuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InformacionUsuarioDTO> createInformacionUsuario(@RequestBody InformacionUsuarioDTO aInformacionUsuarioDTO) {
        var informacion = this.informacionUsuarioService.createInformacionUsuario(InformacionUsuarioMapper.INSTANCE.toInformacionUsuario(aInformacionUsuarioDTO));
        return new ResponseEntity<>(InformacionUsuarioMapper.INSTANCE.toInformacionUsuarioDTO(informacion), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<InformacionUsuarioDTO> updateInformacionUsuario(@RequestBody InformacionUsuarioDTO aInformacionUsuarioDTO) {
        var informacion = this.informacionUsuarioService.updateInformacionUsuario(InformacionUsuarioMapper.INSTANCE.toInformacionUsuario(aInformacionUsuarioDTO));
        return new ResponseEntity<>(InformacionUsuarioMapper.INSTANCE.toInformacionUsuarioDTO(informacion), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteInformacionUsuario(@PathVariable(value = "id") Long aId) {
        this.informacionUsuarioService.deleteInformacionUsuario(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setInformacionUsuarioService(IInformacionUsuarioService informacionUsuarioService){
        this.informacionUsuarioService = informacionUsuarioService;
    }
}