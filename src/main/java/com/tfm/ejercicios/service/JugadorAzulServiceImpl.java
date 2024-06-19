package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.JugadorAzulRepository;
import com.tfm.ejercicios.data.JugadorRojoRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JugadorAzulServiceImpl implements JugadorAzulService {

    @Autowired
    private JugadorAzulRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public JugadorAzul createJugadoresAzulesRestantes(JugadorAzulDto request, Ejercicio ejercicio) {

        if (request == null || ejercicio == null) {
            return null;
        }

        JugadorAzul jugadorAzul = JugadorAzul.builder()
                .nombre(request.getNombre())
                .x(request.getX())
                .y(request.getY())
                .ejercicio(ejercicio)
                .build();

        return repository.save(jugadorAzul);
    }

    @Override
    public JugadorAzul updateJugadorAzul(Long jugadorAzulId, JugadorAzulDto updateRequest) {
        JugadorAzul jugadorAzul = repository.getById(jugadorAzulId);
        if (jugadorAzul != null) {
            jugadorAzul.update(updateRequest);
            repository.save(jugadorAzul);
            return jugadorAzul;
        } else {
            return null;
        }
    }
}
