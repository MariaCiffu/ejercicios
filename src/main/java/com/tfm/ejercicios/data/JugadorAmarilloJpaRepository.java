package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorAmarillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JugadorAmarilloJpaRepository extends JpaRepository<JugadorAmarillo, Long>, JpaSpecificationExecutor<JugadorAmarillo> {

}
