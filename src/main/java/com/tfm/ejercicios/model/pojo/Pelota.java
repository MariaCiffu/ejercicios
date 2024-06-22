package com.tfm.ejercicios.model.pojo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("Pelota")

public class Pelota extends DatoPizarra{

}
