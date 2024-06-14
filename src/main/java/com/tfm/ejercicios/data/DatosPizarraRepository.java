package com.tfm.ejercicios.data;

import com.tfm.ejercicios.data.utils.SearchCriteria;
import com.tfm.ejercicios.data.utils.SearchOperation;
import com.tfm.ejercicios.data.utils.SearchStatement;
import com.tfm.ejercicios.model.pojo.DatosPizarra;
import com.tfm.ejercicios.model.pojo.Ejercicio;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatosPizarraRepository {

    private final DatosPizarraJpaRepository repository;

    public DatosPizarra getById(Long id) {return repository.findById(id).orElse(null);}

    public DatosPizarra save(DatosPizarra datosPizarra) {
        return repository.save(datosPizarra);
    }
}
