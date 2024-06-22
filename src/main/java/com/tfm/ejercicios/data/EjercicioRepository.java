package com.tfm.ejercicios.data;

import com.tfm.ejercicios.data.utils.SearchCriteria;
import com.tfm.ejercicios.data.utils.SearchOperation;
import com.tfm.ejercicios.data.utils.SearchStatement;
import com.tfm.ejercicios.model.pojo.Ejercicio;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EjercicioRepository {

    private final EjercicioJpaRepository repository;

    public List<Ejercicio> getEjercicios() {
        return repository.findAll();
    }

    public Ejercicio getById(Long id) {return repository.findById(id).orElse(null);}

    public Ejercicio save(Ejercicio ejercicio) {
        return repository.save(ejercicio);
    }

    public void delete(Ejercicio ejercicio) {
        repository.delete(ejercicio);
    }

    public List<Ejercicio> search(String nombre, String tipo, String objetivo) {
        SearchCriteria<Ejercicio> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(nombre)) {
            spec.add(new SearchStatement("nombre", nombre, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(tipo)) {
            spec.add(new SearchStatement("tipo", tipo, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(objetivo)) {
            spec.add(new SearchStatement("objetivo", objetivo, SearchOperation.MATCH));
        }

        return repository.findAll(spec);
    }

    public Ejercicio saveAndFlush(Ejercicio ejercicio) {
        return repository.saveAndFlush(ejercicio);
    }

}
