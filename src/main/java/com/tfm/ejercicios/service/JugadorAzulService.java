package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

public interface JugadorAzulService {

    JugadorAzul createJugadoresAzulesRestantes(JugadorAzulDto request, Ejercicio ejercicio);
    JugadorAzul updateJugadorAzul(Long jugadorAzulId, JugadorAzulDto updateRequest);
}

