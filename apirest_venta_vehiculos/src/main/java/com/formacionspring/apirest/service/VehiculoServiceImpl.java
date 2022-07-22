package com.formacionspring.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacionspring.apirest.entity.Vehiculo;
import com.formacionspring.apirest.entity.Venta;
import com.formacionspring.apirest.repository.VehiculoDao;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoDao vehiculoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> mostrarTodos() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vehiculo mostrarPorId(Long id) {
		return vehiculoDao.findById(id).orElse(null);
	}

	@Override
	public Vehiculo guardar(Vehiculo vehiculo) {
		return vehiculoDao.save(vehiculo);
	}

	@Override
	public void borrar(Long id) {
		vehiculoDao.deleteById(id);
		
	}

	@Override
	public List<Venta> mostrarVentas() {
		return null;
	}
	
	

}
