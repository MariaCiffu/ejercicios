package com.tfm.ejercicios.model.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DatoPizarraDto {

    private Integer idRef;

    private Integer id;

    private Double x;

    private Double y;

    private String nombre;
}
