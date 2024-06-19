package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.Cono;
import com.tfm.ejercicios.model.pojo.ConoAlto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConoAltoRepository {

    private final ConoAltoJpaRepository repository;

    public ConoAlto getById(Long id) {return repository.findById(id).orElse(null);}

    public ConoAlto save(ConoAlto conoAlto) {
        return repository.save(conoAlto);
    }
}
