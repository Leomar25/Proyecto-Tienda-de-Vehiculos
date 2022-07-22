package com.formacionspring.apirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.formacionspring.apirest.entity.Vehiculo;

@Repository
public interface VehiculoDao extends CrudRepository<Vehiculo, Long>{

}
