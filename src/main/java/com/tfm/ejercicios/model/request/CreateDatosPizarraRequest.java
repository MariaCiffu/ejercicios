package com.tfm.ejercicios.model.request;

import com.tfm.ejercicios.model.pojo.DatosPizarraDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDatosPizarraRequest {

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private Integer x;

    private Integer y;
}
