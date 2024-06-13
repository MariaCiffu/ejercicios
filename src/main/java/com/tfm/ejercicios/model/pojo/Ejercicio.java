package com.tfm.ejercicios.model.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "imagen")
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
    private Set<DatosPizarra> datosPizarra = new HashSet<>();

    public void update(EjercicioDto ejercicioDto) {
        this.imagen = ejercicioDto.getImagen();
        this.nombre = ejercicioDto.getNombre();
        this.tipo = ejercicioDto.getTipo();
        this.objetivo = ejercicioDto.getObjetivo();
        this.duracion = ejercicioDto.getDuracion();
        this.unidadesDuracion = ejercicioDto.getUnidadesDuracion();
        this.descripcion = ejercicioDto.getDescripcion();

        this.datosPizarra.clear(); // Limpiar la colección actual
        ejercicioDto.getDatosPizarra().forEach(datosPizarraDto -> {
            DatosPizarra nuevosDatosPizarra = new DatosPizarra();
            nuevosDatosPizarra.setTipo(datosPizarraDto.getTipo());
            nuevosDatosPizarra.setNombre(datosPizarraDto.getNombre());
            nuevosDatosPizarra.setX(datosPizarraDto.getX());
            nuevosDatosPizarra.setY(datosPizarraDto.getY());
            nuevosDatosPizarra.setEjercicio(this); // Asocia los DatosPizarra con el Ejercicio actual
            this.datosPizarra.add(nuevosDatosPizarra);
        });
    }
}
