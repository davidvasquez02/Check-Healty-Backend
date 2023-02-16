package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.ExamenUsuario;
import com.software.checkhealtybackend.model.TomaExamen;
import com.software.checkhealtybackend.repository.IExamenUsuarioRepository;
import com.software.checkhealtybackend.repository.ITipoFrecuenciaRepository;
import com.software.checkhealtybackend.repository.ITomaExamenRepository;
import com.software.checkhealtybackend.service.interfaces.IExamenUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ExamenUsuarioServiceImpl implements IExamenUsuarioService {

    private IExamenUsuarioRepository examenUsuarioRepository;

    private ITomaExamenRepository tomaExamenRepository;

    private ITipoFrecuenciaRepository tipoFrecuenciaRepository;

    @Override
    public List<ExamenUsuario> findById(Long aId) {
        return this.examenUsuarioRepository.findByIdEnfermedadUsuario(aId);
    }

    @Override
    @Transactional
    public ExamenUsuario createExamenUsuario(ExamenUsuario aExamenUsuario){
        var examen = this.examenUsuarioRepository.save(aExamenUsuario);

        //Crear TomaExamen
        Date dateFrecuencia = aExamenUsuario.getFechaInicio();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFrecuencia);
        for(int i=0; i<50; i=i+1){
            TomaExamen tomaExamen = new TomaExamen();
            tomaExamen.setIdExamenUsuario(aExamenUsuario.getIdEnfermedadUsuario());
            tomaExamen.setNroExamen(Long.valueOf(i));
            tomaExamen.setCheckk(false);
            tomaExamen.setFechaHora(dateFrecuencia);
            this.tomaExamenRepository.save(tomaExamen);


            //Sumar cantidad de horas
            var value = this.tipoFrecuenciaRepository.findById(aExamenUsuario.getIdTipoFrecuencia());
            int newFrecuencia = Integer.valueOf((int) (value.get().getMultiplicador()* aExamenUsuario.getFrecuencia()*60));
            calendar.add(Calendar.MINUTE, newFrecuencia);
            dateFrecuencia = calendar.getTime();
        }

        return examen;
    }

    @Override
    @Transactional
    public ExamenUsuario updateExamenUsuario(ExamenUsuario aExamenUsuario){
        return this.examenUsuarioRepository.save(aExamenUsuario);
    }

    @Override
    @Transactional
    public void deleteExamenUsuario(Long aId) {
        this.examenUsuarioRepository.deleteById(aId);
    }


    @Autowired
    public void setExamenUsuarioRepository(IExamenUsuarioRepository examenUsuarioRepository){
        this.examenUsuarioRepository = examenUsuarioRepository;
    }

    @Autowired
    public void setTipoFrecuenciaRepository(ITipoFrecuenciaRepository tipoFrecuenciaRepository){
        this.tipoFrecuenciaRepository = tipoFrecuenciaRepository;
    }


    @Autowired
    public void setTomaExamenRepository(ITomaExamenRepository tomaExamenRepository){
        this.tomaExamenRepository = tomaExamenRepository;
    }
}

