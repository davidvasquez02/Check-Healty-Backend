package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.Topico;
import com.software.checkhealtybackend.repository.ITopicoRepository;
import com.software.checkhealtybackend.service.interfaces.ITopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoServiceImpl implements ITopicoService {

    private ITopicoRepository topicoRepository;


    @Override
    public Topico findById(Long aId) {
        return this.topicoRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public Topico createTopico(Topico aTopico){
        return this.topicoRepository.save(aTopico);
    }

    @Override
    @Transactional
    public Topico updateTopico(Topico aTopico){
        return this.topicoRepository.save(aTopico);
    }

    @Override
    @Transactional
    public void deleteTopico(Long aId) {
        this.topicoRepository.deleteById(aId);
    }


    @Autowired
    public void setTopicoRepository(ITopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }
}