package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import com.tfm.ejercicios.model.pojo.JugadorRojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JugadorRojoRepository {

    private final JugadorRojoJpaRepository repository;

    public JugadorRojo getById(Long id) {return repository.findById(id).orElse(null);}

    public JugadorRojo save(JugadorRojo jugadorRojo) {
        return repository.save(jugadorRojo);
    }
}
