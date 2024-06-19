package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import com.tfm.ejercicios.model.pojo.JugadorAmarilloDto;

import java.util.List;

public interface JugadorAmarilloService {

    void updateElement(Ejercicio ejercicio, List<JugadorAmarilloDto> nuevosDatos);
    JugadorAmarillo createJugadoresAmarillosRestantes(JugadorAmarilloDto request, Ejercicio ejercicio);
    JugadorAmarillo updateJugadorAmarillo(Long jugadorAmarilloId, JugadorAmarilloDto updateRequest);
}

