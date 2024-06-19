package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.EjercicioRepository;
import com.tfm.ejercicios.model.pojo.*;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import com.tfm.ejercicios.model.request.CreateJugadorAmarilloRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EjerciciosServiceImpl implements EjerciciosService {

    @Autowired
    private EjercicioRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Ejercicio> getEjercicios(String nombre, String tipo, String objetivo) {

        if (StringUtils.hasLength(nombre) || StringUtils.hasLength(tipo) || StringUtils.hasLength(objetivo)) {
            return repository.search(nombre, tipo, objetivo);
        }

        List<Ejercicio> ejercicios = repository.getEjercicios();
        return ejercicios.isEmpty() ? null : ejercicios;
    }

    @Override
    public Ejercicio getEjercicio(String ejercicioId) { return repository.getById(Long.valueOf(ejercicioId));}

    @Override
    public Boolean removeEjercicio(String ejercicioId) {

        Ejercicio ejercicio = repository.getById(Long.valueOf(ejercicioId));

        if (ejercicio != null) {
            repository.delete(ejercicio);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public Ejercicio createEjercicio(CreateEjercicioRequest request) {

        if (request == null) {
            return null;
        }

        // Validación de los campos del request usando Jakarta Bean Validation
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CreateEjercicioRequest>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            return null;
        }

        // Crear y guardar el Ejercicio
        Ejercicio ejercicio = Ejercicio.builder()
                .imagen(request.getImagen())
                .nombre(request.getNombre())
                .tipo(request.getTipo())
                .objetivo(request.getObjetivo())
                .duracion(request.getDuracion())
                .unidadesDuracion(request.getUnidadesDuracion())
                .descripcion(request.getDescripcion())
                .build();

        // Asociar y guardar los DatosPizarra
        ejercicio.setJugadorRojo(request.getJugadorRojo().stream()
                .map(jugadorRojoDto -> JugadorRojo.builder()
                        .nombre(jugadorRojoDto.getNombre())
                        .idRef(jugadorRojoDto.getIdRef())
                        .x(jugadorRojoDto.getX())
                        .y(jugadorRojoDto.getY())
                        .ejercicio(ejercicio)
                        .build())
                .collect(Collectors.toList()));

        ejercicio.setJugadorAmarillo(request.getJugadorAmarillo().stream()
                .map(jugadorAmarilloDto -> JugadorAmarillo.builder()
                        .nombre(jugadorAmarilloDto.getNombre())
                        .idRef(jugadorAmarilloDto.getIdRef())
                        .x(jugadorAmarilloDto.getX())
                        .y(jugadorAmarilloDto.getY())
                        .ejercicio(ejercicio)
                        .build())
                .collect(Collectors.toList()));

        return repository.save(ejercicio);
    }

    @Override
    public Ejercicio updateEjercicio(String ejercicioId, EjercicioDto updateRequest) {
        Ejercicio ejercicio = repository.getById(Long.valueOf(ejercicioId));
        if (ejercicio != null) {
            ejercicio.update(updateRequest);
            repository.save(ejercicio);
            return ejercicio;
        } else {
            return null;
        }
    }
}
