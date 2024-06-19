package com.tfm.ejercicios.data;


import com.tfm.ejercicios.model.pojo.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EjercicioJpaRepository extends JpaRepository<Ejercicio, Long>, JpaSpecificationExecutor<Ejercicio> {

}
