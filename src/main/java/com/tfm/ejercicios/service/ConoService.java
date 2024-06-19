package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.*;

import java.util.List;

public interface ConoService {
    void updateElement(Ejercicio ejercicio, List<ConoDto> nuevosDatos);
    Cono createConosRestantes(ConoDto request, Ejercicio ejercicio);
    Cono updateCono(Long conoId, ConoDto updateRequest);
}

