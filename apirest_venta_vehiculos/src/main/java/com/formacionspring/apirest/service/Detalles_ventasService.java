package com.formacionspring.apirest.service;

import java.util.List;
import com.formacionspring.apirest.entity.Detalles_ventas;
import com.formacionspring.apirest.entity.Venta;

public interface Detalles_ventasService {
	
		//METODO PARA MOSTRAR TODAS LOS DETALLES DE LAS COMPRAS//
		public List<Detalles_ventas> mostrarTodos();
		
		//METODO PARA MOSTRAR UN DETALLE DE UNA COMPRA POR ID//
		public Detalles_ventas mostrarPorId(Long id);
		
		//METODO PARA GUARDAR UN DETALLE DE UNA COMPRA//
		public Detalles_ventas guardar(Detalles_ventas detalles_ventas);
		
		//METODO PARA BORRAR UN DETALLE DE UNA COMPRA//
		public void borrar(Long id);
		
		//METODO PARA MOSTRAR TODAS LAS VENTAS//
		public List<Venta> mostrarVentas();

}
