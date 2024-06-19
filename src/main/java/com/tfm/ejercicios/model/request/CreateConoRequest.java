package com.tfm.ejercicios.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateConoRequest {

    private Integer idRef;

    private Integer x;

    private Integer y;
}
