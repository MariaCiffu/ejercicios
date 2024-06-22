package com.tfm.ejercicios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfm.ejercicios.data.JugadorRosaRepository;
import com.tfm.ejercicios.data.PelotaRepository;
import com.tfm.ejercicios.model.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PelotaServiceImpl implements PelotaService {

    @Autowired
    private PelotaRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

//    @Override
//    public Pelota createPelotasRestantes(PelotaDto request, Ejercicio ejercicio) {
//
//        if (request == null || ejercicio == null) {
//            return null;
//        }
//
//        Pelota pelota = Pelota.builder()
//                .x(request.getX())
//                .y(request.getY())
//                .ejercicio(ejercicio)
//                .build();
//
//        return repository.save(pelota);
//    }
//
//    @Override
//    public Pelota updatePelota(Long pelotaId, PelotaDto updateRequest) {
//        Pelota pelota = repository.getById(pelotaId);
//        if (pelota != null) {
//            pelota.update(updateRequest);
//            repository.save(pelota);
//            return pelota;
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void updateElement(Ejercicio ejercicio, List<PelotaDto> nuevosDatos) {
//        for (int i = 0; i < nuevosDatos.size(); i ++) {
//            if (i < ejercicio.getPelota().size()){
//                this.updatePelota(ejercicio.getPelota().get(i).getId(), nuevosDatos.get(i));
//            } else {
//                this.createPelotasRestantes(nuevosDatos.get(i), ejercicio);
//
//            }
//        }
//        if (nuevosDatos.size() < ejercicio.getPelota().size()){
//            for(int i = nuevosDatos.size(); i < ejercicio.getPelota().size(); i++) {
//                ejercicio.getPelota().remove(ejercicio.getPelota().get(i));
//            }
//        }
//    }
}
