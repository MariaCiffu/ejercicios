package com.tfm.ejercicios.model.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatoPizarraResponse {
    private Long id;
    private Integer idRef;
    private Double x;
    private Double y;
    private String nombre;
}
