package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

public interface JugadorRojoService {

    JugadorRojo createJugadoresRojosRestantes(JugadorRojoDto request, Ejercicio ejercicio);
    JugadorRojo updateJugadorRojo(Long jugadorRojoId, JugadorRojoDto updateRequest);
}

