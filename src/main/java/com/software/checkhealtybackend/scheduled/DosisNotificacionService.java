package com.software.checkhealtybackend.scheduled;

import com.software.checkhealtybackend.dto.Notification;
import com.software.checkhealtybackend.dto.ServiceNotificationDTO;
import com.software.checkhealtybackend.model.Token;
import com.software.checkhealtybackend.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Component
@EnableScheduling
public class DosisNotificacionService {

    @Autowired
    private ITokenRepository tokenRepository;

    RestTemplate restTemplate = new RestTemplate();


    @Scheduled(fixedDelay = 60000)
    public void dosisMedicamentoPorMinuto() {
        System.out.println("EJECUTA CONSULTA PARA NOTIFICACIONES DE DOSIS MEDICINA EN HORA ACTUAL");

        String fooResourceUrl
                = "https://fcm.googleapis.com/fcm/send";
        ServiceNotificationDTO serviceNotificationDTO = new ServiceNotificationDTO();
        Notification notification = new Notification();
        notification.setTitle("Es hora de tomar la medicina");
        notification.setBody("body");
        serviceNotificationDTO.setNotification(notification);
        Optional<Token> token = tokenRepository.findById(1);
        System.out.println(token.get().getToken());
        serviceNotificationDTO.setTo(token.get().getToken());

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

//        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//        params.add("Authorization", "key=AAAAXnozP-I:APA91bEB5VxKzgSaDwv79PzW2XPyqgwxZajS-IQjMbR_nFYfnYp6PVSZ_q-DKNBal8umNOWq2beXxKKt-FfFXqs5QjYcI0atEIp35Py22eLyItZe4og7juchGcZPTY4LdUB8K16RTi5I");

//
//        ResponseEntity<String> response
//                = restTemplate.postForEntity(fooResourceUrl + "/1",serviceNotificationDTO, String.class);


    }

    @Scheduled(fixedDelay = 60000)
    public void tomaExamenPorMinuto() {
        System.out.println("EJECUTA CONSULTA PARA NOTIFICACIONES DE TOMA DE EXAMEN EN HORA ACTUAL");
    }
}
