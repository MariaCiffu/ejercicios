package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@DiscriminatorValue("JugadorRojo")

public class JugadorRojo extends DatoPizarra {

    private String nombre;
}
