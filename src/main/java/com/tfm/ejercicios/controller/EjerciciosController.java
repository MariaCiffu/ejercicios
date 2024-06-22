package com.tfm.ejercicios.controller;

import com.tfm.ejercicios.model.pojo.*;
import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import com.tfm.ejercicios.model.response.EjercicioResponse;
import com.tfm.ejercicios.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Ejercicios Controller", description = "Microservicio encargado de exponer operaciones CRUD sobre ejercicios alojados en una base de datos en memoria.")
public class EjerciciosController {
    private final EjerciciosService service;

    @GetMapping("/ejercicios")
    @Operation(
            operationId = "Obtener ejercicios",
            description = "Operación de lectura",
            summary = "Se devuelve una lista de todos los ejercicios almacenados en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EjercicioResponse.class)))
    public ResponseEntity<List<EjercicioResponse>> getEjercicios(
            @RequestHeader Map<String, String> headers,
            @Parameter(name = "nombre", description = "Nombre del ejercicio", required = false)
            @RequestParam(required = false) String nombre,
            @Parameter(name = "tipo", description = "Tipo del ejercicio", required = false)
            @RequestParam(required = false) String tipo,
            @Parameter(name = "objetivo", description = "Objetivo del ejercicio", required = false)
            @RequestParam(required = false) String objetivo) {

        log.info("headers: {}", headers);
        List<EjercicioResponse> ejercicios = service.getEjercicios(nombre, tipo, objetivo);

        if (ejercicios != null) {
            return ResponseEntity.ok(ejercicios);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/ejercicios/{ejercicioId}")
    @Operation(
            operationId = "Obtener un ejercicio",
            description = "Operación de lectura",
            summary = "Se devuelve un ejercicio a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EjercicioResponse.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el miembro con el identificador indicado.")
    public ResponseEntity<EjercicioResponse> getEjercicio(@PathVariable String ejercicioId) {

        log.info("Request received for exercise {}", ejercicioId);
        EjercicioResponse ejercicio = service.getEjercicio(ejercicioId);

        if (ejercicio != null) {
            return ResponseEntity.ok(ejercicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/ejercicios/{ejercicioId}")
    @Operation(
            operationId = "Eliminar un ejercicio",
            description = "Operación de escritura",
            summary = "Se elimina un ejercicio a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el ejercicio con el identificador indicado.")
    public ResponseEntity<Void> deleteEjercicio(@PathVariable String ejercicioId) {

        Boolean removed = service.removeEjercicio(ejercicioId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ejercicios")
    @Operation(
            operationId = "Insertar un ejercicio",
            description = "Operación de escritura",
            summary = "Se crea un ejercicio a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del ejercicio a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateEjercicioRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Ejercicio.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    public ResponseEntity<EjercicioResponse> addEjercicio(@RequestBody CreateEjercicioRequest request) {

        EjercicioResponse createdEjercicio = service.createEjercicio(request);

        if (createdEjercicio != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEjercicio);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/ejercicios/{ejercicioId}")
    @Operation(
            operationId = "Modificar totalmente un ejercicio",
            description = "Operación de escritura",
            summary = "Se modifica totalmente un ejercicio.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del ejercicio a actualizar.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = CreateEjercicioRequest.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EjercicioResponse.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Ejercicio no encontrado.")
    public ResponseEntity<EjercicioResponse> updateEjercicio(@PathVariable String ejercicioId, @RequestBody CreateEjercicioRequest body) {

        //Ejercicio
        EjercicioResponse updatedEjercicio = service.updateEjercicio(ejercicioId, body);

        if (updatedEjercicio != null) {
            return ResponseEntity.ok(updatedEjercicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
