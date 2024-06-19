package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import com.tfm.ejercicios.model.pojo.JugadorAmarilloDto;

public interface JugadorAmarilloService {

    JugadorAmarillo createJugadoresAmarillosRestantes(JugadorAmarilloDto request, Ejercicio ejercicio);
    JugadorAmarillo updateJugadorAmarillo(Long jugadorAmarilloId, JugadorAmarilloDto updateRequest);
}

