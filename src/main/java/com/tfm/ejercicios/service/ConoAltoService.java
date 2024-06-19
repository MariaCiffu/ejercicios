package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

import java.util.List;

public interface ConoAltoService {
    void updateElement(Ejercicio ejercicio, List<ConoAltoDto> nuevosDatos);
    ConoAlto createConosAltosRestantes(ConoAltoDto request, Ejercicio ejercicio);
    ConoAlto updateConoAlto(Long conoAltoId, ConoAltoDto updateRequest);
}

