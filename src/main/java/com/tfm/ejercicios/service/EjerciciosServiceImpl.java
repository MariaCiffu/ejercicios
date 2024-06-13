package com.tfm.ejercicios.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.tfm.ejercicios.data.EjercicioRepository;
import com.tfm.ejercicios.model.pojo.DatosPizarra;
import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.EjercicioDto;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Ejercicio getEjercicio(String miembroId) { return repository.getByIdAndDatos(Long.valueOf(miembroId));}

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

        //Otra opcion: Jakarta Validation: https://www.baeldung.com/java-validation
        if (request != null && StringUtils.hasLength(request.getImagen().trim())
                && StringUtils.hasLength(request.getNombre().trim())
                && StringUtils.hasLength(request.getTipo().trim())
                && StringUtils.hasLength(request.getObjetivo().trim())
                && StringUtils.hasLength(request.getDuracion().trim())
                && StringUtils.hasLength(request.getUnidadesDuracion().trim())
                && StringUtils.hasLength(request.getDescripcion().trim())) {

            Ejercicio ejercicio = Ejercicio.builder()
                    .imagen(request.getImagen())
                    .nombre(request.getNombre())
                    .tipo(request.getTipo())
                    .objetivo(request.getObjetivo())
                    .duracion(request.getDuracion())
                    .unidadesDuracion(request.getUnidadesDuracion())
                    .descripcion(request.getDescripcion())
                    .build();

            Set<DatosPizarra> datosPizarraSet = request.getDatosPizarra().stream()
                    .map(datosPizarraDto -> {
                        DatosPizarra datosPizarra = new DatosPizarra();
                        datosPizarra.setTipo(datosPizarraDto.getTipo());
                        datosPizarra.setNombre(datosPizarraDto.getNombre());
                        datosPizarra.setX(datosPizarraDto.getX());
                        datosPizarra.setY(datosPizarraDto.getY());
                        datosPizarra.setEjercicio(ejercicio);
                        return datosPizarra;
                    })
                    .collect(Collectors.toSet());

            ejercicio.setDatosPizarra(datosPizarraSet);
            return repository.save(ejercicio);
        } else {
            return null;
        }
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
