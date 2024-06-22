package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.JugadorRojoRepository;
import com.tfm.ejercicios.data.JugadorRosaRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JugadorRosaServiceImpl implements JugadorRosaService {

    @Autowired
    private JugadorRosaRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

//    @Override
//    public JugadorRosa createJugadoresRosasRestantes(JugadorRosaDto request, Ejercicio ejercicio) {
//
//        if (request == null || ejercicio == null) {
//            return null;
//        }
//
//        JugadorRosa jugadorRosa = JugadorRosa.builder()
//                .nombre(request.getNombre())
//                .x(request.getX())
//                .y(request.getY())
//                .ejercicio(ejercicio)
//                .build();
//
//        return repository.save(jugadorRosa);
//    }
//
//    @Override
//    public JugadorRosa updateJugadorRosa(Long jugadorRosaId, JugadorRosaDto updateRequest) {
//        JugadorRosa jugadorRosa = repository.getById(jugadorRosaId);
//        if (jugadorRosa != null) {
//            jugadorRosa.update(updateRequest);
//            repository.save(jugadorRosa);
//            return jugadorRosa;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void updateElement(Ejercicio ejercicio, List<JugadorRosaDto> nuevosDatos) {
//        for (int i = 0; i < nuevosDatos.size(); i ++) {
//            if (i < ejercicio.getJugadorRosa().size()){
//                this.updateJugadorRosa(ejercicio.getJugadorRosa().get(i).getId(), nuevosDatos.get(i));
//            } else {
//                this.createJugadoresRosasRestantes(nuevosDatos.get(i), ejercicio);
//
//            }
//        }
//        if (nuevosDatos.size() < ejercicio.getJugadorRosa().size()){
//            for(int i = nuevosDatos.size(); i < ejercicio.getJugadorRosa().size(); i++) {
//                ejercicio.getJugadorRosa().remove(ejercicio.getJugadorRosa().get(i));
//            }
//        }
//    }
}
