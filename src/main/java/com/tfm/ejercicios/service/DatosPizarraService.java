package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.DatosPizarra;
import com.tfm.ejercicios.model.pojo.DatosPizarraDto;
import com.tfm.ejercicios.model.pojo.Ejercicio;

public interface DatosPizarraService {

    DatosPizarra createDatosPizarraRestantes(DatosPizarraDto request, Ejercicio ejercicio);
    DatosPizarra updateDatosPizarra(Long datosPizarraId, DatosPizarraDto updateRequest);
}

