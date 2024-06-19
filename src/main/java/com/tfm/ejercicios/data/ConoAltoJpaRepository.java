package com.tfm.ejercicios.data;

import com.tfm.ejercicios.model.pojo.Cono;
import com.tfm.ejercicios.model.pojo.ConoAlto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConoAltoJpaRepository extends JpaRepository<ConoAlto, Long>, JpaSpecificationExecutor<ConoAlto> {

}
