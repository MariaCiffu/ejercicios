package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.EjercicioRepository;
import com.tfm.ejercicios.model.pojo.*;
import com.tfm.ejercicios.model.request.CreateDatoPizarraRequest;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import com.tfm.ejercicios.model.response.DatoPizarraResponse;
import com.tfm.ejercicios.model.response.EjercicioResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EjerciciosServiceImpl implements EjerciciosService {

    @Autowired
    private EjercicioRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<EjercicioResponse> getEjercicios(String nombre, String tipo, String objetivo) {

        if (StringUtils.hasLength(nombre) || StringUtils.hasLength(tipo) || StringUtils.hasLength(objetivo)) {
            return repository.search(nombre, tipo, objetivo).stream()
                    .map(ejercicio -> getEjercicio(ejercicio.getId().toString()))
                    .toList();
        }

        List<EjercicioResponse> ejercicioResponses = repository.getEjercicios().stream()
                .map(ejercicio -> getEjercicio(ejercicio.getId().toString()))
                .toList();

        return ejercicioResponses.isEmpty() ? null : ejercicioResponses;
    }

    @Override
    public EjercicioResponse getEjercicio(String ejercicioId) {
        Ejercicio ejercicio = repository.getById(Long.valueOf(ejercicioId));

        // Transformar los datosPizarra al formato deseado
        return this.crearRespuesta(ejercicio);
    }


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
    public EjercicioResponse createEjercicio(CreateEjercicioRequest request) {

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
                .tipoEj(request.getTipo())
                .objetivo(request.getObjetivo())
                .duracion(request.getDuracion())
                .unidadesDuracion(request.getUnidadesDuracion())
                .descripcion(request.getDescripcion())
                .build();
        repository.save(ejercicio);


        ejercicio.setDatoPizarra(this.createDatosPizarra(ejercicio, request));

        // Guardar el ejercicio en la base de datos
        repository.save(ejercicio);

        return this.crearRespuesta(ejercicio);
    }

    public List<DatoPizarra> createDatosPizarra(Ejercicio ejercicio, CreateEjercicioRequest request) {
        List<DatoPizarra> datosPizarra = new ArrayList<>();

        // Asociar y guardar los jugadores rojos
        for (Map.Entry<String, List<CreateDatoPizarraRequest>> entry : request.getDatosPizarra().entrySet()) {
            for (CreateDatoPizarraRequest datoReq : entry.getValue()) {
                if (("jugadoresRojos").equals(entry.getKey())) {
                    JugadorRojo jugadorRojo = JugadorRojo.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .nombre(datoReq.getNombre())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(jugadorRojo);
                } else if (("jugadoresAmarillos").equals(entry.getKey())) {
                    JugadorAmarillo jugadorAmarillo = JugadorAmarillo.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .nombre(datoReq.getNombre())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(jugadorAmarillo);
                } else if (("jugadoresRosas").equals(entry.getKey())) {
                    JugadorRosa jugadorRosa = JugadorRosa.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .nombre(datoReq.getNombre())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(jugadorRosa);
                } else if (("jugadoresAzules").equals(entry.getKey())) {
                    JugadorAzul jugadorAzul = JugadorAzul.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .nombre(datoReq.getNombre())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(jugadorAzul);
                } else if (("pelotas").equals(entry.getKey())) {
                    Pelota pelota = Pelota.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(pelota);
                } else if (("conos").equals(entry.getKey())) {
                    Cono cono = Cono.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(cono);
                } else if (("conosAltos").equals(entry.getKey())) {
                    ConoAlto conoAlto = ConoAlto.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(conoAlto);
                } else if (("microvallas").equals(entry.getKey())) {
                    Microvalla microvalla = Microvalla.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(microvalla);
                } else if (("picas").equals(entry.getKey())) {
                    Pica pica = Pica.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(pica);
                } else if (("escaleras").equals(entry.getKey())) {
                    Escalera escalera = Escalera.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(escalera);
                } else if (("porterias").equals(entry.getKey())) {
                    Porteria porteria = Porteria.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(porteria);
                } else if (("lineasRectas").equals(entry.getKey())) {
                    LineaRecta lineaRecta = LineaRecta.builder()
                            .idRef(datoReq.getIdRef())
                            .puntos(datoReq.getPuntos())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(lineaRecta);
                }else if (("textos").equals(entry.getKey())) {
                    Texto texto = Texto.builder()
                            .x(datoReq.getX())
                            .y(datoReq.getY())
                            .idRef(datoReq.getIdRef())
                            .nombre(datoReq.getNombre())
                            .ejercicio(ejercicio)
                            .build();
                    datosPizarra.add(texto);
                }

            }
        }
        return datosPizarra;
    }

    public EjercicioResponse crearRespuesta(Ejercicio ejercicio) {
        // Crear el DTO (Data Transfer Object) para la respuesta
        EjercicioResponse ejercicioResponse = EjercicioResponse.builder()
                .id(ejercicio.getId())
                .imagen(ejercicio.getImagen())
                .nombre(ejercicio.getNombre())
                .tipoEj(ejercicio.getTipoEj())
                .objetivo(ejercicio.getObjetivo())
                .duracion(ejercicio.getDuracion())
                .unidadesDuracion(ejercicio.getUnidadesDuracion())
                .descripcion(ejercicio.getDescripcion())
                .build();


        // Crear la estructura de datos para 'datosPizarra'
        Map<String, List<DatoPizarraResponse>> datosPizarraMap = new HashMap<>();
        datosPizarraMap.put("jugadoresRojos", new ArrayList<>());
        datosPizarraMap.put("jugadoresAmarillos", new ArrayList<>());
        datosPizarraMap.put("jugadoresRosas", new ArrayList<>());
        datosPizarraMap.put("jugadoresAzules", new ArrayList<>());
        datosPizarraMap.put("pelotas", new ArrayList<>());
        datosPizarraMap.put("conos", new ArrayList<>());
        datosPizarraMap.put("conosAltos", new ArrayList<>());
        datosPizarraMap.put("microvallas", new ArrayList<>());
        datosPizarraMap.put("picas", new ArrayList<>());
        datosPizarraMap.put("escaleras", new ArrayList<>());
        datosPizarraMap.put("porterias", new ArrayList<>());
        datosPizarraMap.put("lineasRectas", new ArrayList<>());
        datosPizarraMap.put("textos", new ArrayList<>());

        // Llenar la estructura de datos con los objetos de 'DatoPizarra'
        for (DatoPizarra dato : ejercicio.getDatoPizarra()) {
            DatoPizarraResponse datoResponse = new DatoPizarraResponse();
            datoResponse.setId(dato.getId());
            datoResponse.setIdRef(dato.getIdRef());
            datoResponse.setX(dato.getX());
            datoResponse.setY(dato.getY());

            // Verificar si el objeto 'DatoPizarra' es una instancia de una subclase que tiene un nombre
            if (dato instanceof JugadorRojo) {
                JugadorRojo jugadorRojo = (JugadorRojo) dato;
                datoResponse.setNombre(jugadorRojo.getNombre());
                datosPizarraMap.computeIfAbsent("jugadoresRojos", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof JugadorAmarillo) {
                JugadorAmarillo jugadorAmarillo = (JugadorAmarillo) dato;
                datoResponse.setNombre(jugadorAmarillo.getNombre());
                datosPizarraMap.computeIfAbsent("jugadoresAmarillos", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof JugadorRosa) {
                JugadorRosa jugadorRosa = (JugadorRosa) dato;
                datoResponse.setNombre(jugadorRosa.getNombre());
                datosPizarraMap.computeIfAbsent("jugadoresRosas", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof JugadorAzul) {
                JugadorAzul jugadorAzul = (JugadorAzul) dato;
                datoResponse.setNombre(jugadorAzul.getNombre());
                datosPizarraMap.computeIfAbsent("jugadoresAzules", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Pelota) {
                datosPizarraMap.computeIfAbsent("pelotas", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Cono) {
                datosPizarraMap.computeIfAbsent("conos", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof ConoAlto) {
                datosPizarraMap.computeIfAbsent("conosAltos", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Microvalla) {
                datosPizarraMap.computeIfAbsent("microvallas", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Pica) {
                datosPizarraMap.computeIfAbsent("picas", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Escalera) {
                datosPizarraMap.computeIfAbsent("escaleras", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Porteria) {
                datosPizarraMap.computeIfAbsent("porterias", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof LineaRecta) {
                LineaRecta lineaRecta = (LineaRecta) dato;
                datoResponse.setPuntos(lineaRecta.getPuntos());
                datosPizarraMap.computeIfAbsent("lineasRectas", k -> new ArrayList<>()).add(datoResponse);
            } else if (dato instanceof Texto) {
                Texto texto = (Texto) dato;
                datoResponse.setNombre(texto.getNombre());
                datosPizarraMap.computeIfAbsent("textos", k -> new ArrayList<>()).add(datoResponse);
            }
        }

        // Asignar la estructura de datos al DTO
        ejercicioResponse.setDatosPizarra(datosPizarraMap);

        // Devolver el DTO
        return ejercicioResponse;
    }

    @Override
    public EjercicioResponse updateEjercicio(String ejercicioId, CreateEjercicioRequest updateRequest) {
        Ejercicio ejercicio = repository.getById(Long.valueOf(ejercicioId));
        if (ejercicio != null) {
            ejercicio.update(updateRequest);

            // Vaciar la colección de DatoPizarra
            ejercicio.getDatoPizarra().clear();
            repository.saveAndFlush(ejercicio); // Guardar y sincronizar el estado

            // Añadir los nuevos DatoPizarra a la misma colección
            List<DatoPizarra> nuevosDatosPizarra = this.createDatosPizarra(ejercicio, updateRequest);
            for (DatoPizarra dato : nuevosDatosPizarra) {
                ejercicio.getDatoPizarra().add(dato);
                dato.setEjercicio(ejercicio); // Establecer la relación inversa
            }

            repository.save(ejercicio); // Guardar el ejercicio con los nuevos DatoPizarra
            return this.crearRespuesta(ejercicio);
        } else {
            return null;
        }
    }

}
