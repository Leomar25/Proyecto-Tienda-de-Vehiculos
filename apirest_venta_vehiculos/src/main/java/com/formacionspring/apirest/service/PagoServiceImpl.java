package com.formacionspring.apirest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacionspring.apirest.entity.Pago;
import com.formacionspring.apirest.entity.Venta;
import com.formacionspring.apirest.repository.PagoDao;

@Service
public class PagoServiceImpl implements PagoService {
	
	@Autowired
	private PagoDao pagoDao;

	@Override
	@Transactional(readOnly = true)	
	public List<Pago> mostrarTodos() {
		return (List<Pago>) pagoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)	
	public Pago mostrarPorId(Long id) {
		return pagoDao.findById(id).orElse(null);
	}

	@Override
	public Pago guardar(Pago pago) {
		return pagoDao.save(pago);
	}

	@Override
	public void borrar(Long id) {
		pagoDao.deleteById(id);
	}

	@Override
	public List<Venta> mostrarVentas() {
		return null;
	}
	
	
}
