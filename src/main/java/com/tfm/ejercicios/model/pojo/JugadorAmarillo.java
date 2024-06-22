package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@DiscriminatorValue("JugadorAmarillo")

public class JugadorAmarillo extends DatoPizarra{

    private String nombre;
}
