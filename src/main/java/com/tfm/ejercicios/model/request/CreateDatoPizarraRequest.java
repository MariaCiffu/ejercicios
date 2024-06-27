package com.tfm.ejercicios.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDatoPizarraRequest {

    private Integer id;

    private Integer idRef;

    private Double x;

    private Double y;

    private String nombre;

    private List<Double> puntos;
}
