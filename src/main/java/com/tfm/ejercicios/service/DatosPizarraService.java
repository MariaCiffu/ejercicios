package com.tfm.ejercicios.service;


import com.tfm.ejercicios.model.pojo.DatosPizarra;
import com.tfm.ejercicios.model.pojo.DatosPizarraDto;

import java.util.List;

public interface DatosPizarraService {

    DatosPizarra updateDatosPizarra(Long datosPizarraId, DatosPizarraDto updateRequest);
}
