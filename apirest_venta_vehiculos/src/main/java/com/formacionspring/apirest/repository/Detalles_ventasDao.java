package com.formacionspring.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.formacionspring.apirest.entity.Detalles_ventas;

@Repository
public interface Detalles_ventasDao extends CrudRepository<Detalles_ventas, Long> {

}
