package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.ConoRepository;
import com.tfm.ejercicios.data.PelotaRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConoServiceImpl implements ConoService {

    @Autowired
    private ConoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Cono createConosRestantes(ConoDto request, Ejercicio ejercicio) {

        if (request == null || ejercicio == null) {
            return null;
        }

        Cono cono = Cono.builder()
                .x(request.getX())
                .y(request.getY())
                .ejercicio(ejercicio)
                .build();

        return repository.save(cono);
    }

    @Override
    public Cono updateCono(Long conoId, ConoDto updateRequest) {
        Cono cono = repository.getById(conoId);
        if (cono != null) {
            cono.update(updateRequest);
            repository.save(cono);
            return cono;
        } else {
            return null;
        }
    }

    @Override
    public void updateElement(Ejercicio ejercicio, List<ConoDto> nuevosDatos) {
        for (int i = 0; i < nuevosDatos.size(); i ++) {
            if (i < ejercicio.getCono().size()){
                this.updateCono(ejercicio.getCono().get(i).getId(), nuevosDatos.get(i));
            } else {
                this.createConosRestantes(nuevosDatos.get(i), ejercicio);

            }
        }
        if (nuevosDatos.size() < ejercicio.getCono().size()){
            for(int i = nuevosDatos.size(); i < ejercicio.getCono().size(); i++) {
                ejercicio.getCono().remove(ejercicio.getCono().get(i));
            }
        }
    }
}
