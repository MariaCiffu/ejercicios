package com.tfm.ejercicios.model.pojo;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DatosPizarraDto {

    private String tipo;

    private String nombre;

    private Integer x;

    private Integer y;
}
