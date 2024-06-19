package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.Ejercicio;
import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JugadorAmarilloRepository {

    private final JugadorAmarilloJpaRepository repository;

    public JugadorAmarillo getById(Long id) {return repository.findById(id).orElse(null);}

    public JugadorAmarillo save(JugadorAmarillo jugadorAmarillo) {
        return repository.save(jugadorAmarillo);
    }
}
