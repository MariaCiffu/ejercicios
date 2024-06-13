package com.tfm.ejercicios.model.request;

import com.tfm.ejercicios.model.pojo.DatosPizarra;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEjercicioRequest {

    private String imagen;

    private String nombre;

    private String tipo;

    private String objetivo;

    private String duracion;

    private String unidadesDuracion;

    private String descripcion;

    private Set<DatosPizarra> datosPizarra;
}
