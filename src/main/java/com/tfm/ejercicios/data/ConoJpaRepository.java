package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.Cono;
import com.tfm.ejercicios.model.pojo.Pelota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConoJpaRepository extends JpaRepository<Cono, Long>, JpaSpecificationExecutor<Cono> {

}
