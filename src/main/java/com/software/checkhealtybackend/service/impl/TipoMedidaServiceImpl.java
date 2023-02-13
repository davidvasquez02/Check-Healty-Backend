package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.TipoMedida;
import com.software.checkhealtybackend.repository.ITipoMedidaRepository;
import com.software.checkhealtybackend.service.interfaces.ITipoMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoMedidaServiceImpl implements ITipoMedidaService {

    private ITipoMedidaRepository tipoMedidaRepository;


    @Override
    public TipoMedida findById(Long aId) {
        return this.tipoMedidaRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public TipoMedida createTipoMedida(TipoMedida aTipoMedida){
        return this.tipoMedidaRepository.save(aTipoMedida);
    }

    @Override
    @Transactional
    public TipoMedida updateTipoMedida(TipoMedida aTipoMedida){
        return this.tipoMedidaRepository.save(aTipoMedida);
    }

    @Override
    @Transactional
    public void deleteTipoMedida(Long aId) {
        this.tipoMedidaRepository.deleteById(aId);
    }


    @Autowired
    public void setTipRepository(ITipoMedidaRepository tipoMedidaRepository){
        this.tipoMedidaRepository = tipoMedidaRepository;
    }
}
