package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@SuperBuilder
@DiscriminatorValue("Cono")
public class Cono extends DatoPizarra{

}
