package com.tfm.ejercicios.model.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEjercicioRequest {

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

    @NotNull(message = "Los datos de pizarra no pueden ser nulos")
    private List<CreateJugadorRojoRequest> jugadorRojo;

    @NotNull(message = "Los datos de pizarra no pueden ser nulos")
    private List<CreateJugadorAmarilloRequest> jugadorAmarillo;
}
