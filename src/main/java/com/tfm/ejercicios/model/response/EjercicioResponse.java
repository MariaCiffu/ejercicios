package com.tfm.ejercicios.model.response;

import com.tfm.ejercicios.model.pojo.Ejercicio;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EjercicioResponse {
    private Long id;

    private String imagen;

    private String nombre;

    private String tipoEj;

    private String objetivo;

    private String duracion;

    private String unidadesDuracion;

    private String descripcion;

    // Estructura para contener los diferentes tipos de DatoPizarra
    private Map<String, List<DatoPizarraResponse>> datosPizarra;
}
