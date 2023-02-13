package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.TipoFrecuencia;
import org.springframework.stereotype.Service;

@Service
public interface ITipoFrecuenciaService {

    TipoFrecuencia findById (Long aId);

    TipoFrecuencia createTipoFrecuencia(TipoFrecuencia aTipoFrecuencia);

    TipoFrecuencia updateTipoFrecuencia(TipoFrecuencia aTipoFrecuencia);

    void deleteTipoFrecuencia(Long aId);
}