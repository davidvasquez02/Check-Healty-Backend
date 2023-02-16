package com.software.checkhealtybackend.service.impl;

import com.software.checkhealtybackend.model.DosisMedicamento;
import com.software.checkhealtybackend.model.MedicamentoUsuario;
import com.software.checkhealtybackend.repository.IDosisMedicamentoRepository;
import com.software.checkhealtybackend.repository.IMedicamentoUsuarioRepository;
import com.software.checkhealtybackend.repository.ITipoFrecuenciaRepository;
import com.software.checkhealtybackend.service.interfaces.IMedicamentoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MedicamentoUsuarioImpl implements IMedicamentoUsuarioService {

    private IMedicamentoUsuarioRepository medicamentoUsuarioRepository;

    private IDosisMedicamentoRepository dosisMedicamentoRepository;

    private ITipoFrecuenciaRepository tipoFrecuenciaRepository;


    @Override
    public List<MedicamentoUsuario> findById(Long aId) {
        return this.medicamentoUsuarioRepository.findByIdEnfermedadUsuario(aId);
    }

    @Override
    @Transactional
    public MedicamentoUsuario createMedicamentoUsuario(MedicamentoUsuario aMedicamentoUsuario){
        var medicamentoUsuario = this.medicamentoUsuarioRepository.save(aMedicamentoUsuario);

        //Crear DosisMedicamento
        Date dateFrecuencia = aMedicamentoUsuario.getFechaInicio();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFrecuencia);
        for(int i=0; i<50; i=i+1){
            DosisMedicamento dosisMedicamento = new DosisMedicamento();
            dosisMedicamento.setIdMedicamentoUsuario(medicamentoUsuario.getId());
            dosisMedicamento.setNroDosis(Long.valueOf(i));
            dosisMedicamento.setCheckk(false);
            dosisMedicamento.setFechaHora(dateFrecuencia);
            this.dosisMedicamentoRepository.save(dosisMedicamento);


            //Sumar cantidad de horas
            var value = this.tipoFrecuenciaRepository.findById(aMedicamentoUsuario.getIdTipoFrecuencia());
            int newFrecuencia = Integer.valueOf((int) (value.get().getMultiplicador()* aMedicamentoUsuario.getFrecuencia()*60));
            calendar.add(Calendar.MINUTE, newFrecuencia);
            dateFrecuencia = calendar.getTime();
        }

        return medicamentoUsuario;
    }

    @Override
    @Transactional
    public MedicamentoUsuario updateMedicamentoUsuario(MedicamentoUsuario aMedicamentoUsuario){
        return this.medicamentoUsuarioRepository.save(aMedicamentoUsuario);
    }

    @Override
    @Transactional
    public void deleteMedicamentoUsuario(Long aId) {
        this.medicamentoUsuarioRepository.deleteById(aId);
    }


    @Autowired
    public void setMedicamentoUsuarioRepository(IMedicamentoUsuarioRepository medicamentoUsuarioRepository){
        this.medicamentoUsuarioRepository = medicamentoUsuarioRepository;
    }


    @Autowired
    public void setDosisMedicamentoRepository(IDosisMedicamentoRepository dosisMedicamentoRepository){
        this.dosisMedicamentoRepository = dosisMedicamentoRepository;
    }

    @Autowired
    public void setTipoFrecuenciaRepository(ITipoFrecuenciaRepository tipoFrecuenciaRepository){
        this.tipoFrecuenciaRepository = tipoFrecuenciaRepository;
    }
}

