package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DatoPizarra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class DatoPizarra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idRef")
    private Integer idRef;

    @Column(name = "x")
    private Double x;

    @Column(name = "y")
    private Double y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejercicio_id")
    @JsonIgnore
    private Ejercicio ejercicio;

}
