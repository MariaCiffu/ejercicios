package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugadorAmarillo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JugadorAmarillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idRef")
    private Integer idRef;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ejercicio_id")
    @JsonIgnore
    private Ejercicio ejercicio;

    public void update(JugadorAmarilloDto jugadorAmarilloDto) {
        this.nombre = jugadorAmarilloDto.getNombre();
        this.idRef = jugadorAmarilloDto.getIdRef();
        this.x = jugadorAmarilloDto.getX();
        this.y = jugadorAmarilloDto.getY();
    }
}
