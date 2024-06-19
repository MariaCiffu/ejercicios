package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorAzul;
import com.tfm.ejercicios.model.pojo.JugadorRosa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JugadorAzulRepository {

    private final JugadorAzulJpaRepository repository;

    public JugadorAzul getById(Long id) {return repository.findById(id).orElse(null);}

    public JugadorAzul save(JugadorAzul jugadorAzul) {
        return repository.save(jugadorAzul);
    }
}
