package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.DatosPizarraRepository;
import com.tfm.ejercicios.data.EjercicioRepository;
import com.tfm.ejercicios.model.pojo.DatosPizarra;
import com.tfm.ejercicios.model.pojo.DatosPizarraDto;
import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.EjercicioDto;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DatosPizarraServiceImpl implements DatosPizarraService {

    @Autowired
    private DatosPizarraRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public DatosPizarra createDatosPizarraRestantes(DatosPizarraDto request, Ejercicio ejercicio) {

        if (request == null || ejercicio == null) {
            return null;
        }

        DatosPizarra datosPizarra = DatosPizarra.builder()
                .tipo(request.getTipo())
                .nombre(request.getNombre())
                .x(request.getX())
                .y(request.getY())
                .ejercicio(ejercicio)
                .build();

        return repository.save(datosPizarra);
    }

    @Override
    public DatosPizarra updateDatosPizarra(Long datosPizarraId, DatosPizarraDto updateRequest) {
        DatosPizarra datosPizarra = repository.getById(datosPizarraId);
        if (datosPizarra != null) {
            datosPizarra.update(updateRequest);
            repository.save(datosPizarra);
            return datosPizarra;
        } else {
            return null;
        }
    }
}
