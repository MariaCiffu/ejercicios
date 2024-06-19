package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorRojo;
import com.tfm.ejercicios.model.pojo.JugadorRosa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JugadorRosaRepository {

    private final JugadorRosaJpaRepository repository;

    public JugadorRosa getById(Long id) {return repository.findById(id).orElse(null);}

    public JugadorRosa save(JugadorRosa jugadorRosa) {
        return repository.save(jugadorRosa);
    }
}
