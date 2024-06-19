package com.tfm.ejercicios.model.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JugadorRojoDto {

    private String nombre;

    private Integer idRef;

    private Integer x;

    private Integer y;
}
