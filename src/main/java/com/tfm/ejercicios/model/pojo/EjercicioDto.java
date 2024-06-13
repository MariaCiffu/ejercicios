package com.tfm.ejercicios.model.pojo;

import lombok.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EjercicioDto {

    private String imagen;

    private String nombre;

    private String tipo;

    private String objetivo;

    private String duracion;

    private String unidadesDuracion;

    private String descripcion;

    private Set<DatosPizarra> datosPizarra;
}
