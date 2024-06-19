package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorRosa;
import com.tfm.ejercicios.model.pojo.Pelota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PelotaJpaRepository extends JpaRepository<Pelota, Long>, JpaSpecificationExecutor<Pelota> {

}
