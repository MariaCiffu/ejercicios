package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.JugadorRojoRepository;
import com.tfm.ejercicios.data.JugadorRosaRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JugadorRosaServiceImpl implements JugadorRosaService {

    @Autowired
    private JugadorRosaRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public JugadorRosa createJugadoresRosasRestantes(JugadorRosaDto request, Ejercicio ejercicio) {

        if (request == null || ejercicio == null) {
            return null;
        }

        JugadorRosa jugadorRosa = JugadorRosa.builder()
                .nombre(request.getNombre())
                .x(request.getX())
                .y(request.getY())
                .ejercicio(ejercicio)
                .build();

        return repository.save(jugadorRosa);
    }

    @Override
    public JugadorRosa updateJugadorRosa(Long jugadorRosaId, JugadorRosaDto updateRequest) {
        JugadorRosa jugadorRosa = repository.getById(jugadorRosaId);
        if (jugadorRosa != null) {
            jugadorRosa.update(updateRequest);
            repository.save(jugadorRosa);
            return jugadorRosa;
        } else {
            return null;
        }
    }
}
