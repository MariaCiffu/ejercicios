package com.tfm.ejercicios.service;

import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.EjercicioDto;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import com.tfm.ejercicios.model.response.EjercicioResponse;

import java.util.List;

public interface EjerciciosService {

    List<EjercicioResponse> getEjercicios(String nombre, String tipo, String objetivo);

    EjercicioResponse getEjercicio(String ejercicioId);

    Boolean removeEjercicio(String ejercicioId);

    EjercicioResponse createEjercicio(CreateEjercicioRequest request);

    EjercicioResponse updateEjercicio(String ejercicioId, CreateEjercicioRequest updateRequest);
}
