package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.JugadorAmarilloRepository;
import com.tfm.ejercicios.data.JugadorRojoRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JugadorRojoServiceImpl implements JugadorRojoService {

    @Autowired
    private JugadorRojoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

//    @Override
//    public JugadorRojo createJugadoresRojosRestantes(JugadorRojoDto request, Ejercicio ejercicio) {
//
//        if (request == null || ejercicio == null) {
//            return null;
//        }
//
//        JugadorRojo jugadorRojo = JugadorRojo.builder()
//                .nombre(request.getNombre())
//                .x(request.getX())
//                .y(request.getY())
//                .ejercicio(ejercicio)
//                .build();
//
//        return repository.save(jugadorRojo);
//    }
//
//    @Override
//    public JugadorRojo updateJugadorRojo(Long jugadorRojoId, JugadorRojoDto updateRequest) {
//        JugadorRojo jugadorRojo = repository.getById(jugadorRojoId);
//        if (jugadorRojo != null) {
//            jugadorRojo.update(updateRequest);
//            repository.save(jugadorRojo);
//            return jugadorRojo;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void updateElement(Ejercicio ejercicio, List<JugadorRojoDto> nuevosDatos) {
//        for (int i = 0; i < nuevosDatos.size(); i ++) {
//            if (i < ejercicio.getJugadorRojo().size()){
//                this.updateJugadorRojo(ejercicio.getJugadorRojo().get(i).getId(), nuevosDatos.get(i));
//            } else {
//                this.createJugadoresRojosRestantes(nuevosDatos.get(i), ejercicio);
//
//            }
//        }
//        if (nuevosDatos.size() < ejercicio.getJugadorRojo().size()){
//            for(int i = nuevosDatos.size(); i < ejercicio.getJugadorRojo().size(); i++) {
//                ejercicio.getJugadorRojo().remove(ejercicio.getJugadorRojo().get(i));
//            }
//        }
//    }
}
