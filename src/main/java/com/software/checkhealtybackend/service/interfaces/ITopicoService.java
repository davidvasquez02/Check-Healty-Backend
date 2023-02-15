package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.Topico;
import org.springframework.stereotype.Service;

@Service
public interface ITopicoService {

    Topico findById (Long aId);

    Topico createTopico(Topico aTopico);

    Topico updateTopico(Topico aTopico);

    void deleteTopico(Long aId);
}