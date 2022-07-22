package com.formacionspring.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.formacionspring.apirest.entity.Detalles_ventas;
import com.formacionspring.apirest.service.Detalles_ventasService;

@RestController
@RequestMapping("/api")
public class Detalles_ventasRestController {
	
	@Autowired
	private Detalles_ventasService servicio;
	
	//METODO PARA MOSTRAR TODOS LOS DETALLES DE LAS VENTAS/
		@GetMapping({"/detalles_ventas","/"})
		public List<Detalles_ventas> index() {
			return servicio.mostrarTodos();	
		}

		//METODO PARA MOSTRAR UN DETALLE DE VENTAS POR ID//
		@GetMapping("/detalles_ventas/{id}")
		public ResponseEntity<?> show(@PathVariable long id) {
			
			 Detalles_ventas detalles_ventas = null;
		        Map<String,Object>  response = new HashMap<>();

		        try {

		            detalles_ventas = servicio.mostrarPorId(id);

		        } catch (DataAccessException e) {
		            response.put("mensaje", "Error al realizar en base de datos");
		            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		        if(detalles_ventas == null) {
		            response.put("mensaje", "El dellate de la venta con ID: "+id+" no existe en la base de datos");
		            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		        }

		        return new ResponseEntity<Detalles_ventas>(detalles_ventas,HttpStatus.OK);
		    }
		
		//METODO PARA CREAR UN DETALLE DE VENTAS//
		@PostMapping("/detalles_ventas")
	    public ResponseEntity<?> create(@RequestBody Detalles_ventas detalles_ventas) {
	        Detalles_ventas detalles_ventaseNew = null;
	        Map<String,Object>  response = new HashMap<>();

	        try {

	        	detalles_ventaseNew =  servicio.guardar(detalles_ventas);

	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","EL detalle de la venta ha sido creado con éxito");
	        response.put("producto",detalles_ventaseNew);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	       
	        
	    }
		
		//METODO PARA ACTUALIZAR UN DETALLE DE LA VENTA//
		@PutMapping("/detalles_ventas/{id}")
	    public ResponseEntity<?> update(@RequestBody Detalles_ventas detalles_ventas
	            ,@PathVariable Long id) {

	        Detalles_ventas detalles_ventasUpdate =  servicio.mostrarPorId(id);
	        Map<String,Object>  response = new HashMap<>();


	        if(detalles_ventasUpdate == null) {
	            response.put("mensaje","No existe el registro con id:"+id);
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	        }

	        try {


	        	detalles_ventasUpdate.setPreciocompra(detalles_ventasUpdate.getPrecioventa());
	        	detalles_ventasUpdate.setCantidad(detalles_ventasUpdate.getCantidad());
	            
	            //guardo y retorno los datos actualizados
	            servicio.guardar(detalles_ventasUpdate);
	          
	           
	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","El detalle de la venta ha sido actualizado con éxito");
	        response.put("producto", detalles_ventasUpdate);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	    }
		//METODO PARA BORRAR UN DETALLE DE UNA VENTA//
		@DeleteMapping("/detalles_ventas/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        Detalles_ventas detalles_ventasBorrado = servicio.mostrarPorId(id);
	        Map<String,Object>  response = new HashMap<>();

	        if(detalles_ventasBorrado == null) {
	            response.put("mensaje","No existe el registro con id:"+id);
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	        }
	        servicio.borrar(id);

	        response.put("mensaje","El detalle de la venta ha sido eliminada con éxito");
	        response.put("cliente", detalles_ventasBorrado);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);


	    }

		
		

	
	

}
