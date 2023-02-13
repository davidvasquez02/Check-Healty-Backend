package com.software.checkhealtybackend.service.interfaces;

import com.software.checkhealtybackend.model.InformacionUsuario;
import org.springframework.stereotype.Service;

@Service
public interface IInformacionUsuarioService {

    InformacionUsuario findById (Long aId);

    InformacionUsuario createInformacionUsuario(InformacionUsuario aInformacionUsuario);

    InformacionUsuario updateInformacionUsuario(InformacionUsuario aInformacionUsuario);

    void deleteInformacionUsuario(Long aId);
}