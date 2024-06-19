package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

import java.util.List;

public interface JugadorAzulService {
    void updateElement(Ejercicio ejercicio, List<JugadorAzulDto> nuevosDatos);
    JugadorAzul createJugadoresAzulesRestantes(JugadorAzulDto request, Ejercicio ejercicio);
    JugadorAzul updateJugadorAzul(Long jugadorAzulId, JugadorAzulDto updateRequest);
}

