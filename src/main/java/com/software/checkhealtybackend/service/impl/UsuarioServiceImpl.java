package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.dto.UsuarioDTO;
import com.software.checkhealtybackend.mappers.UsuarioMapper;
import com.software.checkhealtybackend.model.EnfermedadUsuario;
import com.software.checkhealtybackend.model.InformacionUsuario;
import com.software.checkhealtybackend.model.Usuario;
import com.software.checkhealtybackend.repository.IEnfermedadUsuarioRepository;
import com.software.checkhealtybackend.repository.IExamenUsuarioRepository;
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
        if(usuarioSimilar(aUsuario.getCorreo())){
            Usuario user = this.usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuario(aUsuario));

            //Crear InformacionUsuario
            InformacionUsuario infoUser = new InformacionUsuario();
            infoUser.setIdUsuario(user.getId());
            infoUser.setFechaNacimiento(aUsuario.getFechaNacimiento());
            infoUser.setAlturaMt(aUsuario.getAlturaMt());
            infoUser.setPesoKg(aUsuario.getPesoKg());
            this.informacionUsuarioRepository.save(infoUser);

            //Crear EnfermedadUsuario

            EnfermedadUsuario enfermedadUserDiabetes = new EnfermedadUsuario();
            enfermedadUserDiabetes.setIdUsuario(user.getId());
            enfermedadUserDiabetes.setIdEnfermedad(1L);
            enfermedadUserDiabetes.setPadece(aUsuario.getDiabetes());
            this.enfermedadUsuarioRepository.save(enfermedadUserDiabetes);

            EnfermedadUsuario enfermedadUserHiper = new EnfermedadUsuario();
            enfermedadUserHiper.setIdUsuario(user.getId());
            enfermedadUserHiper.setIdEnfermedad(2L);
            enfermedadUserHiper.setPadece(aUsuario.getHipertension());
            this.enfermedadUsuarioRepository.save(enfermedadUserHiper);

            EnfermedadUsuario enfermedadUserAsma = new EnfermedadUsuario();
            enfermedadUserAsma.setIdUsuario(user.getId());
            enfermedadUserAsma.setIdEnfermedad(3L);
            enfermedadUserAsma.setPadece(aUsuario.getAsma());
            this.enfermedadUsuarioRepository.save(enfermedadUserAsma);

            
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
    public Usuario sesionUsuario(String aCorreo, String aContraseña){
        Usuario user = this.usuarioRepository.sesionUsuario(aCorreo, aContraseña);
        Boolean valid;
        if(user == null){
            valid = false;
        }else{
            valid = true;
        }
        return user;
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
