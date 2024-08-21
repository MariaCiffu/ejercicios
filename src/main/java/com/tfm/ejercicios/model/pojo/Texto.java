package com.tfm.ejercicios.model.pojo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@DiscriminatorValue("Texto")
public class Texto extends DatoPizarra{

    private String nombre;
}
