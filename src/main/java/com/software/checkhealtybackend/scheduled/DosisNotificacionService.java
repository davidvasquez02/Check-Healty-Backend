package com.software.checkhealtybackend.scheduled;

import com.software.checkhealtybackend.controller.DosisMedicamentoController;
import com.software.checkhealtybackend.dto.DosisMedicamentoDTO;
import com.software.checkhealtybackend.dto.Notification;
import com.software.checkhealtybackend.dto.ServiceNotificationDTO;
import com.software.checkhealtybackend.mappers.DosisMedicamentoMapper;
import com.software.checkhealtybackend.model.Token;
import com.software.checkhealtybackend.repository.ITokenRepository;
import com.software.checkhealtybackend.service.impl.DosisMedicamentoServiceImpl;
import com.software.checkhealtybackend.service.interfaces.IDosisMedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Component
@EnableScheduling
public class DosisNotificacionService {

    @Autowired
    private ITokenRepository tokenRepository;

    @Autowired
    IDosisMedicamentoService dosisMedicamentoService;

    RestTemplate restTemplate = new RestTemplate();


    @Scheduled(fixedDelay = 60000)
    public void dosisMedicamentoPorMinuto() {
        System.out.println("EJECUTA CONSULTA PARA NOTIFICACIONES DE DOSIS MEDICINA EN HORA ACTUAL");
        Optional<Token> token = tokenRepository.findById(1);

        System.out.println(token.get().getToken());

        DosisMedicamentoDTO[] response = restTemplate.getForObject(
                "http://localhost:8080/CheckHealth/api/dosisMedicamento/dosisMedicamentoRealizadas?idUsuario=1", DosisMedicamentoDTO[].class);
        List<DosisMedicamentoDTO> dosis = Arrays.asList(response);

//
//        var listaDosisMedicamento = this.dosisMedicamentoService.findDosisMedicamentoByCheck(1L, null, null, null);
//        List<DosisMedicamentoDTO> dosis = listaDosisMedicamento.stream().map(DosisMedicamentoMapper.INSTANCE::toDosisMedicamentoDTO).collect(Collectors.toList());


//        ArrayList<DosisMedicamentoDTO> dosis = (ArrayList<DosisMedicamentoDTO>) dosisMedicamentoController.findDosisMedicamentoByCheck( 1L,null,null,null).getBody();

        dosis.forEach(dosisMedicamentoDTO -> {
            System.out.println(dosisMedicamentoDTO.getFechaHora().toString());
            Date actual = new Date();
            actual.setSeconds(0);
            System.out.println(actual.toString());
            System.out.println("-----------");

            if(dosisMedicamentoDTO.getFechaHora().toString().equals(actual.toString())){
                System.out.println("ENTRA");
                enviaNotificacion("Es hora de tomar: " + dosisMedicamentoDTO.getNombre(), "Recuerda la dosis es de: " + dosisMedicamentoDTO.getDosis() + "" + dosisMedicamentoDTO.getNombreTipoDosis(),token.get().getToken());

            }

        });

    }

    @Scheduled(fixedDelay = 60000)
    public void tomaExamenPorMinuto() {
        System.out.println("EJECUTA CONSULTA PARA NOTIFICACIONES DE TOMA DE EXAMEN EN HORA ACTUAL");
    }

    private void enviaNotificacion(String titulo, String body, String token){
        String fooResourceUrl
                = "https://fcm.googleapis.com/fcm/send";
        ServiceNotificationDTO serviceNotificationDTO = new ServiceNotificationDTO();
        Notification notification = new Notification();
        notification.setTitle(titulo);
        notification.setBody(body);
        serviceNotificationDTO.setNotification(notification);
        serviceNotificationDTO.setTo(token);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","key=AAAAXnozP-I:APA91bEB5VxKzgSaDwv79PzW2XPyqgwxZajS-IQjMbR_nFYfnYp6PVSZ_q-DKNBal8umNOWq2beXxKKt-FfFXqs5QjYcI0atEIp35Py22eLyItZe4og7juchGcZPTY4LdUB8K16RTi5I");

        HttpEntity<ServiceNotificationDTO> requestEntity =
                new HttpEntity<ServiceNotificationDTO>(serviceNotificationDTO, headers);
        ResponseEntity<String> response =
                restTemplate.exchange(fooResourceUrl, HttpMethod.POST, requestEntity,
                        String.class);

        System.out.println(response.getBody());
    }
}
