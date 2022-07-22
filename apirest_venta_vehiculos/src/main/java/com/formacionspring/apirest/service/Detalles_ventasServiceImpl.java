package com.formacionspring.apirest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacionspring.apirest.entity.Detalles_ventas;
import com.formacionspring.apirest.entity.Venta;
import com.formacionspring.apirest.repository.Detalles_ventasDao;

@Service
public class Detalles_ventasServiceImpl implements Detalles_ventasService {
	
	@Autowired
	private Detalles_ventasDao detalles_ventasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Detalles_ventas> mostrarTodos() {
		return (List<Detalles_ventas>) detalles_ventasDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Detalles_ventas mostrarPorId(Long id) {
		return detalles_ventasDao.findById(id).orElse(null);
	}

	@Override
	public Detalles_ventas guardar(Detalles_ventas detalles_ventas) {
		return detalles_ventasDao.save(detalles_ventas);
	}

	@Override
	public void borrar(Long id) {
		detalles_ventasDao.deleteById(id);
	}

	@Override
	public List<Venta> mostrarVentas() {
		return null;
	}
	
	

}
