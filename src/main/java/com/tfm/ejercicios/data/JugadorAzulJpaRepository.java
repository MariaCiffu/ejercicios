package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorAzul;
import com.tfm.ejercicios.model.pojo.JugadorRosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JugadorAzulJpaRepository extends JpaRepository<JugadorAzul, Long>, JpaSpecificationExecutor<JugadorAzul> {

}
