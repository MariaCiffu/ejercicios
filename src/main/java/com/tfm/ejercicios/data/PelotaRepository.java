package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorRosa;
import com.tfm.ejercicios.model.pojo.Pelota;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PelotaRepository {

    private final PelotaJpaRepository repository;

    public Pelota getById(Long id) {return repository.findById(id).orElse(null);}

    public Pelota save(Pelota pelota) {
        return repository.save(pelota);
    }
}
