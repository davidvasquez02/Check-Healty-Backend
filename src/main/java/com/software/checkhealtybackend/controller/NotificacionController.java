package com.software.checkhealtybackend.controller;

import com.software.checkhealtybackend.dto.NotificacionDTO;
import com.software.checkhealtybackend.mappers.NotificacionMapper;
import com.software.checkhealtybackend.service.interfaces.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/notificacion")
public class NotificacionController {

    private INotificacionService notificacionService;


    @GetMapping("/id/{id}")
    public ResponseEntity<NotificacionDTO> findById(@PathVariable(value = "id") Long aId) {
        var notificacion = this.notificacionService.findById(aId);
        return new ResponseEntity<>(NotificacionMapper.INSTANCE.toNotificacionDTO(notificacion), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NotificacionDTO> createNotificacion(@RequestBody NotificacionDTO aNotificacionDTO) {
        var notificacion = this.notificacionService.createNotificacion(NotificacionMapper.INSTANCE.toNotificacion(aNotificacionDTO));
        return new ResponseEntity<>(NotificacionMapper.INSTANCE.toNotificacionDTO(notificacion), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<NotificacionDTO> updateNotificacion(@RequestBody NotificacionDTO aNotificacionDTO) {
        var notificacion = this.notificacionService.updateNotificacion(NotificacionMapper.INSTANCE.toNotificacion(aNotificacionDTO));
        return new ResponseEntity<>(NotificacionMapper.INSTANCE.toNotificacionDTO(notificacion), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Boolean> deleteNotificacion(@PathVariable(value = "id") Long aId) {
        this.notificacionService.deleteNotificacion(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @Autowired
    public void setNotificacionService(INotificacionService notificacionService){
        this.notificacionService = notificacionService;
    }
}

