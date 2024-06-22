package com.tfm.ejercicios.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEjercicioRequest {

    private Integer id;

    @NotBlank(message = "La imagen no puede estar vacía")
    private String imagen;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

    @NotBlank(message = "El objetivo no puede estar vacío")
    private String objetivo;

    @NotBlank(message = "La duración no puede estar vacía")
    private String duracion;

    @NotBlank(message = "Las unidades de duración no pueden estar vacías")
    private String unidadesDuracion;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "Los datos del jugador rojo no pueden ser nulos")
    private Map<String, List<CreateDatoPizarraRequest>> datosPizarra;
}
