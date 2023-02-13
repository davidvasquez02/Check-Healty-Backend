package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.TipoMedida;
import org.springframework.stereotype.Service;

@Service
public interface ITipoMedidaService {

    TipoMedida findById (Long aId);

    TipoMedida createTipoMedida(TipoMedida aTipoMedida);

    TipoMedida updateTipoMedida(TipoMedida aTipoMedida);

    void deleteTipoMedida(Long aId);
}
