package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.JugadorRojo;
import com.tfm.ejercicios.model.pojo.JugadorRosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JugadorRosaJpaRepository extends JpaRepository<JugadorRosa, Long>, JpaSpecificationExecutor<JugadorRosa> {

}
