package com.tfm.ejercicios.model.pojo;

import com.tfm.ejercicios.model.request.CreateEjercicioRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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

    @Column(name = "tipoEj")
    private String tipoEj;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "unidades_duracion")
    private String unidadesDuracion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    List<DatoPizarra> datoPizarra = new ArrayList<>();


    public void update(CreateEjercicioRequest ejercicioDto) {
        this.imagen = ejercicioDto.getImagen();
        this.nombre = ejercicioDto.getNombre();
        this.tipoEj = ejercicioDto.getTipo();
        this.objetivo = ejercicioDto.getObjetivo();
        this.duracion = ejercicioDto.getDuracion();
        this.unidadesDuracion = ejercicioDto.getUnidadesDuracion();
        this.descripcion = ejercicioDto.getDescripcion();
    }
}
