package com.formacionspring.apirest.service;

import java.util.List;
import com.formacionspring.apirest.entity.Cliente;
import com.formacionspring.apirest.entity.Venta;

public interface ClienteService {
	
	//METODO PARA MOSTRAR TODOS LOS CLIENTES//
	public List<Cliente> mostrarTodos();
	
	//METODO PARA MOSTRAR UN CLIENTE POR ID//
	public Cliente mostrarPorId(Long id);
	
	//METODO PARA GUARDAR UN CLIENTE//
	public Cliente guardar(Cliente cliente);
	
	//METODO PARA BORRAR UN CLIENTE//
	public void borrar(Long id);
	
	//METODO PARA MOSTRAR TODAS LAS VENTAS//
	public List<Venta> mostrarVentas();
	

}
