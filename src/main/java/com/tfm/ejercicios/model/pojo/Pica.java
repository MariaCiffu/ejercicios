package com.tfm.ejercicios.model.pojo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue("Pica")
@SuperBuilder

public class Pica extends DatoPizarra{

}
