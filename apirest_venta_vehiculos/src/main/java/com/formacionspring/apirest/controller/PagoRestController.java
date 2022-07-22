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
import com.formacionspring.apirest.entity.Pago;
import com.formacionspring.apirest.service.PagoService;

@RestController
@RequestMapping("/api")
public class PagoRestController {
	
	@Autowired
	private PagoService servicio;
	
	//METODO PARA MOSTRAR TODOS LOS PAGOS//
		@GetMapping({"/pagos","/"})
		public List<Pago> index() {
			return servicio.mostrarTodos();	
		}

		//METODO PARA MOSTRAR UNA COMPRA POR ID//
		@GetMapping("/pagos/{id}")
		public ResponseEntity<?> show(@PathVariable long id) {
			
			 Pago pago = null;
		        Map<String,Object>  response = new HashMap<>();

		        try {

		            pago = servicio.mostrarPorId(id);

		        } catch (DataAccessException e) {
		            response.put("mensaje", "Error al realizar en base de datos");
		            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		        if(pago == null) {
		            response.put("mensaje", "El pago con ID: "+id+" no existe en la base de datos");
		            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		        }

		        return new ResponseEntity<Pago>(pago,HttpStatus.OK);
		    }
		
		//METODO PARA CREAR UN NUEVO PAGO//
		@PostMapping("/pagos")
	    public ResponseEntity<?> create(@RequestBody Pago pago) {
	        Pago pagoNew = null;
	        Map<String,Object>  response = new HashMap<>();

	        try {

	            pagoNew =  servicio.guardar(pago);

	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","El pago ha sido creado con éxito");
	        response.put("producto", pagoNew);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	       
	        
	    }
		
		//METODO PARA ACTUALIZAR UN PAGO//
		@PutMapping("/pagos/{id}")
	    public ResponseEntity<?> update(@RequestBody Pago pago
	            ,@PathVariable Long id) {

	        Pago pagoUpdate =  servicio.mostrarPorId(id);
	        Map<String,Object>  response = new HashMap<>();


	        if(pagoUpdate == null) {
	            response.put("mensaje","No existe el registro con id:"+id);
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	        }

	        try {


	            pagoUpdate.setMonto(pago.getMonto());
	            pagoUpdate.setTipodepago(pago.getTipodepago());
	           
	            //guardo y retorno los datos actualizados
	            servicio.guardar(pagoUpdate);
	          
	           
	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","El pago ha sido actualizado con éxito");
	        response.put("producto", pagoUpdate);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	    }
		//METODO PARA BORRAR UN PAGO//
		@DeleteMapping("/pagos/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        Pago pagoBorrado = servicio.mostrarPorId(id);
	        Map<String,Object>  response = new HashMap<>();

	        if(pagoBorrado == null) {
	            response.put("mensaje","No existe el registro con id:"+id);
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	        }
	        servicio.borrar(id);

	        response.put("mensaje","El pago ha sido eliminada con éxito");
	        response.put("cliente", pagoBorrado);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);


	    }

	
	

}
