package com.formacionspring.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.formacionspring.apirest.entity.Pago;

@Repository
public interface PagoDao extends CrudRepository<Pago, Long> {

}
