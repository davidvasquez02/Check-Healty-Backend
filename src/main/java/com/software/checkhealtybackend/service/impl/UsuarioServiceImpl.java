package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.dto.UsuarioDTO;
import com.software.checkhealtybackend.mappers.UsuarioMapper;
import com.software.checkhealtybackend.model.EnfermedadUsuario;
import com.software.checkhealtybackend.model.InformacionUsuario;
import com.software.checkhealtybackend.model.Usuario;
import com.software.checkhealtybackend.repository.IEnfermedadUsuarioRepository;
import com.software.checkhealtybackend.repository.IInformacionUsuarioRepository;
import com.software.checkhealtybackend.repository.IUsuarioRepository;
import com.software.checkhealtybackend.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;

    private IInformacionUsuarioRepository informacionUsuarioRepository;

    private IEnfermedadUsuarioRepository enfermedadUsuarioRepository;


    @Override
    public Usuario findById(Long aId) {
        return this.usuarioRepository.findById(aId).orElse(null);
    }

    @Override
    @Transactional
    public UsuarioDTO createUsuario(UsuarioDTO aUsuario){
        if(usuarioSimilar(aUsuario.getUsername())){
            Usuario userSaved = usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(aUsuario));

            //Guardado InformacionUsuario
            InformacionUsuario informacionUsuario = new InformacionUsuario();
            informacionUsuario.setIdUsuario(userSaved.getId());
            informacionUsuario.setAlturaMt(aUsuario.getAlturaMt());
            informacionUsuario.setPesoKg(aUsuario.getPesoKg());
            informacionUsuario.setFechaNacimiento(aUsuario.getFechaNacimiento());
            informacionUsuarioRepository.save(informacionUsuario);

            //Guardado EnfermedadUsuario
            EnfermedadUsuario enfermedadUsuario = new EnfermedadUsuario();
            enfermedadUsuario.setIdUsuario(userSaved.getId());
            enfermedadUsuario.setIdEnfermedad(aUsuario.getIdEnfermedad());
            enfermedadUsuario.setPadece(aUsuario.getPadece());
            enfermedadUsuarioRepository.save(enfermedadUsuario);

            return aUsuario;
        }else{return null;}
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario aUsuario){
        return this.usuarioRepository.save(aUsuario);
    }

    @Override
    @Transactional
    public void deleteUsuario(Long aId) {
        this.usuarioRepository.deleteById(aId);
    }

    //Inicio de sesion
    @Override
    @Transactional
    public Long sesionUsuario(String aUser, String aContraseña){
        return this.usuarioRepository.sesionUsuario(aUser, aContraseña).getId();
    }


    //Verificar usuarios similares

    @Transactional
    public Boolean usuarioSimilar(String aUser){
        return this.usuarioRepository.usuarioSimilar(aUser).isEmpty();
    }


    @Autowired
    public void setUsuarioRepository(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setInformacionUsuarioRepository(IInformacionUsuarioRepository informacionUsuarioRepository){
        this.informacionUsuarioRepository = informacionUsuarioRepository;
    }

    @Autowired
    public void setEnfermedadUsuarioRepository(IEnfermedadUsuarioRepository enfermedadUsuarioRepository){
        this.enfermedadUsuarioRepository = enfermedadUsuarioRepository;
    }
}
