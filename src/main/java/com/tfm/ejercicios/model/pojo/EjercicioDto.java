package com.tfm.ejercicios.model.pojo;

import com.tfm.ejercicios.model.request.CreateDatoPizarraRequest;
import lombok.*;

import java.util.List;
import java.util.Map;
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

    private Map<String, List<DatoPizarraDto>> datosPizarra;

}
