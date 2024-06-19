package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.Cono;
import com.tfm.ejercicios.model.pojo.Pelota;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConoRepository {

    private final ConoJpaRepository repository;

    public Cono getById(Long id) {return repository.findById(id).orElse(null);}

    public Cono save(Cono cono) {
        return repository.save(cono);
    }
}
