package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "datosPizarra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DatosPizarra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ejercicio_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Ejercicio ejercicio;
}
