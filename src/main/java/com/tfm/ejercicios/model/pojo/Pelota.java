package com.tfm.ejercicios.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pelota")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Pelota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idRef")
    private Integer idRef;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ejercicio_id")
    @JsonIgnore
    private Ejercicio ejercicio;

    public void update(PelotaDto pelotaDto) {
        this.idRef = pelotaDto.getIdRef();
        this.x = pelotaDto.getX();
        this.y = pelotaDto.getY();
    }
}
