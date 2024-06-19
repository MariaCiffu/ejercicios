package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

import java.util.List;

public interface JugadorRosaService {
    void updateElement(Ejercicio ejercicio, List<JugadorRosaDto> nuevosDatos);
    JugadorRosa createJugadoresRosasRestantes(JugadorRosaDto request, Ejercicio ejercicio);
    JugadorRosa updateJugadorRosa(Long jugadorRosaId, JugadorRosaDto updateRequest);
}

