package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.JugadorAmarilloRepository;
import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import com.tfm.ejercicios.model.pojo.JugadorAmarilloDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JugadorAmarilloServiceImpl implements JugadorAmarilloService {

    @Autowired
    private JugadorAmarilloRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public JugadorAmarillo createJugadoresAmarillosRestantes(JugadorAmarilloDto request, Ejercicio ejercicio) {

        if (request == null || ejercicio == null) {
            return null;
        }

        JugadorAmarillo jugadorAmarillo = JugadorAmarillo.builder()
                .nombre(request.getNombre())
                .x(request.getX())
                .y(request.getY())
                .ejercicio(ejercicio)
                .build();

        return repository.save(jugadorAmarillo);
    }

    @Override
    public JugadorAmarillo updateJugadorAmarillo(Long jugadorAmarilloId, JugadorAmarilloDto updateRequest) {
        JugadorAmarillo jugadorAmarillo = repository.getById(jugadorAmarilloId);
        if (jugadorAmarillo != null) {
            jugadorAmarillo.update(updateRequest);
            repository.save(jugadorAmarillo);
            return jugadorAmarillo;
        } else {
            return null;
        }
    }
}
