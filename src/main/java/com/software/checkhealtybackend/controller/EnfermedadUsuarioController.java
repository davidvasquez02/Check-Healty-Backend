package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.EnfermedadUsuarioDTO;
import com.software.checkhealtybackend.mappers.EnfermedadUsuarioMapper;
import com.software.checkhealtybackend.service.interfaces.IEnfermedadUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/enfermedadUsuario")
public class EnfermedadUsuarioController {

    private IEnfermedadUsuarioService enfermedadUsuarioService;


    @GetMapping("/id/{id}")
    public ResponseEntity<EnfermedadUsuarioDTO> findById(@PathVariable(value = "id") Long aId) {
        var enfermedadUsuario = this.enfermedadUsuarioService.findById(aId);
        return new ResponseEntity<>(EnfermedadUsuarioMapper.INSTANCE.toEnfermedadUsuarioDTO(enfermedadUsuario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnfermedadUsuarioDTO> createEnfermedadUsuario(@RequestBody EnfermedadUsuarioDTO aEnfermedadUsuarioDTO) {
        var enfermedad = this.enfermedadUsuarioService.createEnfermedadUsuario(EnfermedadUsuarioMapper.INSTANCE.toEnfermedadUsuario(aEnfermedadUsuarioDTO));
        return new ResponseEntity<>(EnfermedadUsuarioMapper.INSTANCE.toEnfermedadUsuarioDTO(enfermedad), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EnfermedadUsuarioDTO> updateEnfermedadUsuario(@RequestBody EnfermedadUsuarioDTO aEnfermedadUsuarioDTO) {
        var enfermedad = this.enfermedadUsuarioService.updateEnfermedadUsuario(EnfermedadUsuarioMapper.INSTANCE.toEnfermedadUsuario(aEnfermedadUsuarioDTO));
        return new ResponseEntity<>(EnfermedadUsuarioMapper.INSTANCE.toEnfermedadUsuarioDTO(enfermedad), HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Boolean> deleteEnfermedadUsuario(@RequestParam(value = "id") Long aId) {
        this.enfermedadUsuarioService.deleteEnfermedadUsuario(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Lista EnfermedadUsuario by idUser
    @GetMapping("/allByUser/{idUser}")
    public ResponseEntity <List<EnfermedadUsuarioDTO>> findByIdUser(@PathVariable(value = "idUser") Long aIdUser) {
        var listEnfermedadUsuario = this.enfermedadUsuarioService.findByIdUser(aIdUser);
        return new ResponseEntity<>(listEnfermedadUsuario.stream().map(EnfermedadUsuarioMapper.INSTANCE::toEnfermedadUsuarioDTO).collect(Collectors.toList()), HttpStatus.OK);
    }


    @Autowired
    public void setEnfermedadUsuarioService(IEnfermedadUsuarioService enfermedadUsuarioService){
        this.enfermedadUsuarioService = enfermedadUsuarioService;
    }
}