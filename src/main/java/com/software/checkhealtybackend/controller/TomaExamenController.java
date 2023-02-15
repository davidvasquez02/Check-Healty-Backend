package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TomaExamenDTO;
import com.software.checkhealtybackend.mappers.TomaExamenMapper;
import com.software.checkhealtybackend.service.interfaces.ITomaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tomaExamen")
public class TomaExamenController {

    private ITomaExamenService tomaExamenService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TomaExamenDTO> findById(@PathVariable(value = "id") Long aId) {
        var tomaExamen = this.tomaExamenService.findById(aId);
        return new ResponseEntity<>(TomaExamenMapper.INSTANCE.toTomaExamenDTO(tomaExamen), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TomaExamenDTO> createTomaExamen(@RequestBody TomaExamenDTO aTomaExamenDTO) {
        var tomaExamen = this.tomaExamenService.createTomaExamen(TomaExamenMapper.INSTANCE.toTomaExamen(aTomaExamenDTO));
        return new ResponseEntity<>(TomaExamenMapper.INSTANCE.toTomaExamenDTO(tomaExamen), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TomaExamenDTO> updateTomaExamen(@RequestBody TomaExamenDTO aTomaExamenDTO) {
        var tomaExamen = this.tomaExamenService.updateTomaExamen(TomaExamenMapper.INSTANCE.toTomaExamen(aTomaExamenDTO));
        return new ResponseEntity<>(TomaExamenMapper.INSTANCE.toTomaExamenDTO(tomaExamen), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTomaExamen(@PathVariable(value = "id") Long aId) {
        this.tomaExamenService.deleteTomaExamen(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    //TomasExamen realizadas
    @GetMapping("/tomasExamenRealizadas")
    public ResponseEntity <List<TomaExamenDTO>> findTomaExamenByCheck(@RequestParam(name = "idUsuario") Long User,
                                                                      @RequestParam(name = "fechaDesde", required = false) Date aFechaDesde,
                                                                      @RequestParam(name = "fechaHasta", required = false) Date aFechaHasta,
                                                                      @RequestParam(name = "checkk", required = false) Boolean aCheck) {
        var listaTomaExamen = this.tomaExamenService.findTomaExamenByCheck(User, aFechaDesde, aFechaHasta, aCheck);
        return new ResponseEntity<>(listaTomaExamen.stream().map(TomaExamenMapper.INSTANCE::toTomaExamenDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    //TomasExamen según idUsuario
    @GetMapping("/all")
    public ResponseEntity <List<TomaExamenDTO>> findAllByIdUser(@RequestParam(name = "idUser", required = false) Long aIdUser) {
        var listTomaExamen = this.tomaExamenService.findAllByUser(aIdUser);
        return new ResponseEntity<>(listTomaExamen.stream().map(TomaExamenMapper.INSTANCE::toTomaExamenDTO).collect(Collectors.toList()), HttpStatus.OK);
    }


    @Autowired
    public void setTomaExamenService(ITomaExamenService tomaExamenService){
        this.tomaExamenService = tomaExamenService;
    }
}
