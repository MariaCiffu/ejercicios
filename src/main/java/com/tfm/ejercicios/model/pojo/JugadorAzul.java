package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugadorAzul")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JugadorAzul {

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

    public void update(JugadorAzulDto jugadorAzulDto) {
        this.nombre = jugadorAzulDto.getNombre();
        this.idRef = jugadorAzulDto.getIdRef();
        this.x = jugadorAzulDto.getX();
        this.y = jugadorAzulDto.getY();
    }
}
