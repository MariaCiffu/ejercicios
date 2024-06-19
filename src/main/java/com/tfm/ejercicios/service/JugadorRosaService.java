package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

public interface JugadorRosaService {

    JugadorRosa createJugadoresRosasRestantes(JugadorRosaDto request, Ejercicio ejercicio);
    JugadorRosa updateJugadorRosa(Long jugadorRosaId, JugadorRosaDto updateRequest);
}

