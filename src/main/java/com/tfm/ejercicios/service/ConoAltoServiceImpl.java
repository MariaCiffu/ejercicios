package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.ConoAltoRepository;
import com.tfm.ejercicios.data.ConoRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConoAltoServiceImpl implements ConoAltoService {

    @Autowired
    private ConoAltoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

//    @Override
//    public ConoAlto createConosAltosRestantes(ConoAltoDto request, Ejercicio ejercicio) {
//
//        if (request == null || ejercicio == null) {
//            return null;
//        }
//
//        ConoAlto conoAlto = ConoAlto.builder()
//                .x(request.getX())
//                .y(request.getY())
//                .ejercicio(ejercicio)
//                .build();
//
//        return repository.save(conoAlto);
//    }

//    @Override
//    public ConoAlto updateConoAlto(Long conoAltoId, ConoAltoDto updateRequest) {
//        ConoAlto conoAlto = repository.getById(conoAltoId);
//        if (conoAlto != null) {
//            conoAlto.update(updateRequest);
//            repository.save(conoAlto);
//            return conoAlto;
//        } else {
//            return null;
//        }
//    }

//    @Override
//    public void updateElement(Ejercicio ejercicio, List<ConoAltoDto> nuevosDatos) {
//        for (int i = 0; i < nuevosDatos.size(); i ++) {
//            if (i < ejercicio.getConoAlto().size()){
//                this.updateConoAlto(ejercicio.getConoAlto().get(i).getId(), nuevosDatos.get(i));
//            } else {
//                this.createConosAltosRestantes(nuevosDatos.get(i), ejercicio);
//
//            }
//        }
//        if (nuevosDatos.size() < ejercicio.getConoAlto().size()){
//            for(int i = nuevosDatos.size(); i < ejercicio.getConoAlto().size(); i++) {
//                ejercicio.getConoAlto().remove(ejercicio.getConoAlto().get(i));
//            }
//        }
//    }
}
