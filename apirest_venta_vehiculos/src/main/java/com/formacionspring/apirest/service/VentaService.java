package com.formacionspring.apirest.service;

import java.util.List;

import com.formacionspring.apirest.entity.Venta;

public interface VentaService {
	
	//METODO PARA MOSTRAR TODAS LAS VENTAS//
	public List<Venta> mostrarTodos();
	
	//METODO PARA MOSTRAR UNA VENTA POR ID//
	public Venta mostrarPorId(Long id);
	
	//METODO PARA GUARDAR UNA VENTA//
	public Venta guardar(Venta venta);
	
	//METODO PARA BORRAR UNA VENTA//
	public void borrar(Long id);
	

}
