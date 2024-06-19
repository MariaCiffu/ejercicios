package com.tfm.ejercicios.model.pojo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ejercicios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imagen", columnDefinition = "MEDIUMTEXT")
    @Lob
    private String imagen;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "unidades_duracion")
    private String unidadesDuracion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<JugadorRojo> jugadorRojo = new ArrayList<>();

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<JugadorAmarillo> jugadorAmarillo = new ArrayList<>();

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<JugadorRosa> jugadorRosa = new ArrayList<>();

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<JugadorAzul> jugadorAzul = new ArrayList<>();

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pelota> pelota = new ArrayList<>();

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Cono> cono = new ArrayList<>();

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ConoAlto> conoAlto = new ArrayList<>();

    public void update(EjercicioDto ejercicioDto) {
        this.imagen = ejercicioDto.getImagen();
        this.nombre = ejercicioDto.getNombre();
        this.tipo = ejercicioDto.getTipo();
        this.objetivo = ejercicioDto.getObjetivo();
        this.duracion = ejercicioDto.getDuracion();
        this.unidadesDuracion = ejercicioDto.getUnidadesDuracion();
        this.descripcion = ejercicioDto.getDescripcion();
    }
}
