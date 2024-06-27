package com.tfm.ejercicios.model.pojo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@DiscriminatorValue("LineaRecta")

public class LineaRecta extends DatoPizarra{

    private List<Double> puntos;
}
