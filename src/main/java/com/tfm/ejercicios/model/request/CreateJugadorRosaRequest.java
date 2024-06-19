package com.tfm.ejercicios.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateJugadorRosaRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private Integer idRef;

    private Integer x;

    private Integer y;
}
