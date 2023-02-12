package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.TipDTO;
import com.software.checkhealtybackend.mappers.TipMapper;
import com.software.checkhealtybackend.service.interfaces.ITipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tip")
public class TipController {

    private ITipService tipService;


    @GetMapping("/id/{id}")
    public ResponseEntity<TipDTO> findById(@PathVariable(value = "id") Long aId) {
        var tip = this.tipService.findById(aId);
        return new ResponseEntity<>(TipMapper.INSTANCE.toTipDTO(tip), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipDTO> createTip(@RequestBody TipDTO aTipDTO) {
        var tip = this.tipService.createTip(TipMapper.INSTANCE.toTip(aTipDTO));
        return new ResponseEntity<>(TipMapper.INSTANCE.toTipDTO(tip), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TipDTO> updateTip(@RequestBody TipDTO aTipDTO) {
        var tip = this.tipService.updateTip(TipMapper.INSTANCE.toTip(aTipDTO));
        return new ResponseEntity<>(TipMapper.INSTANCE.toTipDTO(tip), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteTip(@PathVariable(value = "id") Long aId) {
        this.tipService.deleteTip(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setTipService(ITipService tipService){
        this.tipService = tipService;
    }
}
