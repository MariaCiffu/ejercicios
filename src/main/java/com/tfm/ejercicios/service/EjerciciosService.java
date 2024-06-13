package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.EjercicioDto;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;

import java.util.List;

public interface EjerciciosService {

    List<Ejercicio> getEjercicios(String nombre, String tipo, String objetivo);

    Ejercicio getEjercicio(String ejercicioId);

    Boolean removeEjercicio(String ejercicioId);

    Ejercicio createEjercicio(CreateEjercicioRequest request);

    Ejercicio updateEjercicio(String ejercicioId, EjercicioDto updateRequest);
}
