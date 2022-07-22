package com.formacionspring.apirest.service;

import java.util.List;
import com.formacionspring.apirest.entity.Pago;
import com.formacionspring.apirest.entity.Venta;

public interface PagoService {
	

	//METODO PARA MOSTRAR TODOS LOS PAGOS//
	public List<Pago> mostrarTodos();
	
	//METODO PARA MOSTRAR UN PAGO POR ID//
	public Pago mostrarPorId(Long id);
	
	//METODO PARA GUARDAR UN PAGO//
	public Pago guardar(Pago pago);
	
	//METODO PARA BORRAR UN PAGO//
	public void borrar(Long id);
	
	//METODO PARA MOSTRAR TODAS LAS VENTAS//
	public List<Venta> mostrarVentas();

}
