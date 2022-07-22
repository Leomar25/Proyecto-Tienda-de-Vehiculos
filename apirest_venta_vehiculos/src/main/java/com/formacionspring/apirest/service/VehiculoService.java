package com.formacionspring.apirest.service;

import java.util.List;

import com.formacionspring.apirest.entity.Vehiculo;
import com.formacionspring.apirest.entity.Venta;

public interface VehiculoService {
	
	//METODO PARA MOSTRAR TODOS LOS VEHICULOS//
	public List<Vehiculo> mostrarTodos();
	
	//METODO PARA MOSTRAR UN VEHICULO POR ID//
	public Vehiculo mostrarPorId(Long id);
	
	//METODO PARA GUARDAR UN VEHICULO//
	public Vehiculo guardar(Vehiculo vehiculo);
	
	//METODO PARA BORRAR UN VEHICULO//
	public void borrar(Long id);
	
	//METODO PARA MOSTRAR TODAS LAS VENTAS//
	public List<Venta> mostrarVentas();

}
