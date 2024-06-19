package com.tfm.ejercicios.model.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JugadorAzulDto {

    private String nombre;

    private Integer idRef;

    private Integer x;

    private Integer y;
}
