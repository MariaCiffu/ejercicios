package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import com.tfm.ejercicios.model.pojo.JugadorRojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JugadorRojoJpaRepository extends JpaRepository<JugadorRojo, Long>, JpaSpecificationExecutor<JugadorRojo> {

}
