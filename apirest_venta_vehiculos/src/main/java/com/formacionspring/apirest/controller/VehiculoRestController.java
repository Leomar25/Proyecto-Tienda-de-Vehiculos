package com.formacionspring.apirest.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.formacionspring.apirest.entity.Vehiculo;
import com.formacionspring.apirest.service.VehiculoService;

@RestController
@RequestMapping("/api")
public class VehiculoRestController {
	
	@Autowired
	private VehiculoService servicio;
	
	//METODO PARA MOSTRAR TODOS LOS VEHICULOS//
		@GetMapping({"/vehiculos","/"})
		public List<Vehiculo> index() {
			return servicio.mostrarTodos();	
		}

		//METODO PARA MOSTRAR UN VEHICULO POR ID//
		@GetMapping("/vehiculos/{id}")
		public ResponseEntity<?> show(@PathVariable long id) {
			
			 Vehiculo vehiculo = null;
		        Map<String,Object>  response = new HashMap<>();

		        try {

		            vehiculo = servicio.mostrarPorId(id);

		        } catch (DataAccessException e) {
		            response.put("mensaje", "Error al realizar en base de datos");
		            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		        if(vehiculo == null) {
		            response.put("mensaje", "El vehiculo con ID: "+id+" no existe en la base de datos");
		            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		        }

		        return new ResponseEntity<Vehiculo>(vehiculo,HttpStatus.OK);
		    }
		
		//METODO PARA CREAR UN NUEVO VEHICULO//
		@PostMapping("/vehiculos")
	    public ResponseEntity<?> create(@RequestBody Vehiculo vehiculo) {
	        Vehiculo vehiculoNew = null;
	        Map<String,Object>  response = new HashMap<>();

	        try {

	            vehiculoNew =  servicio.guardar(vehiculo);

	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","El vehiculo ha sido creado con éxito");
	        response.put("producto", vehiculoNew);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	       
	        
	    }
		
		//METODO PARA ACTUALIZAR UN VEHICULO//
		@PutMapping("/vehiculos/{id}")
	    public ResponseEntity<?> update(@RequestBody Vehiculo vehiculo
	            ,@PathVariable Long id) {

	        Vehiculo vehiculoUpdate =  servicio.mostrarPorId(id);
	        Map<String,Object>  response = new HashMap<>();


	        if(vehiculoUpdate == null) {
	            response.put("mensaje","No existe el registro con id:"+id);
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	        }

	        try {


	            vehiculoUpdate.setMarca(vehiculo.getMarca());
	            vehiculoUpdate.setModelo(vehiculo.getModelo());
	            vehiculoUpdate.setCilindrada(vehiculo.getCilindrada());
	            vehiculoUpdate.setPotencia(vehiculo.getPotencia());
	            vehiculoUpdate.setVelocidad(vehiculo.getVelocidad());	          
	            vehiculoUpdate.setPvp(vehiculo.getPvp());
	            vehiculoUpdate.setFecharegistro(vehiculo.getFecharegistro());
	            vehiculoUpdate.setCantidad(vehiculo.getCantidad());
	            
	            if (vehiculo.getImagen() != null) {
	            	String nombreFotoAnterior = vehiculo.getImagen();
	                //verificamos que el cliente tenga registrado una imagen
	                if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
	                    //preparamos la ruta a la imagen guardada
	                    Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
	                    File archivoFotoAnterior = rutaFotoAnterior.toFile();
	                    //verificamos que el archivo existe y se pueda leer
	                    if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
	                        //borramos la imagen
	                        archivoFotoAnterior.delete();
	                    }
	                }
	                vehiculo.setImagen(vehiculo.getImagen());
				}
	            
	            //guardo y retorno los datos actualizados
	            servicio.guardar(vehiculoUpdate);

	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","El vehiculo ha sido actualizado con éxito");
	        response.put("producto", vehiculoUpdate);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	    }
		@DeleteMapping("/vehiculos/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        Vehiculo vehiculoBorrado = servicio.mostrarPorId(id);
	        Map<String,Object>  response = new HashMap<>();

	        if(vehiculoBorrado == null) {
	            response.put("mensaje","No existe el registro con id:"+id);
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	        }

	        try {
	        	if(vehiculoBorrado.getImagen()!=null) {
	                String nombreFotoAnterior = vehiculoBorrado.getImagen();
	                //verificamos que el cliente tenga registrado una imagen
	                if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
	                    //preparamos la ruta a la imagen guardada
	                    Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
	                    File archivoFotoAnterior = rutaFotoAnterior.toFile();
	                    //verificamos que el archivo existe y se pueda leer
	                    if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
	                        //borramos la imagen
	                        archivoFotoAnterior.delete();
	                    }
	                }

	            }

	            servicio.borrar(id);

	        } catch (DataAccessException e) {
	            response.put("mensaje", "Error al realizar en base de datos");
	            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje","El vehiculo ha sido eliminado con éxito");
	        response.put("cliente", vehiculoBorrado);
	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);


	    }
		//METODO PARA SUBIR IMAGENES//
		@PostMapping("/vehiculos/Uploads")
	    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo,
	            @RequestParam("id") Long id){

	        Map<String,Object>  response = new HashMap<>();
	        //Buscar el cliente por el id recibido//
	        Vehiculo vehiculo = servicio.mostrarPorId(id);

	        //Preguntamos si el archivo es distinto de vacio//
	        if( !archivo.isEmpty() ) {
	            //Guardamos el nombre del archivo en esta variable//
	        	String nombreArchivo =  UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");

	            //Guardamos la ruta completa uploads/nombredelaimagen lo guardamos en una variable de tipo path que es de java.io//

	            Path rutaArchivo = Paths.get("Uploads").resolve(nombreArchivo).toAbsolutePath();

	            try {
	                //Copiamos el archivo fisico a la ruta que definimos en Path//
	                Files.copy(archivo.getInputStream(), rutaArchivo );
	            } catch (IOException e) {
	                response.put("mensaje", "Error al subir la imagen del producto");
	                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
	                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	            
	            String nombreFotoAnterior = vehiculo.getImagen();
	            //verificamos que el cliente tenga registrado una imagen
	            if(nombreFotoAnterior != null && nombreFotoAnterior.length()>0) {
	                //preparamos la ruta a la imagen guardada
	                Path rutaFotoAnterior = Paths.get("Uploads").resolve(nombreFotoAnterior).toAbsolutePath();
	                File archivoFotoAnterior = rutaFotoAnterior.toFile();
	                //verificamos que el archivo existe y se pueda leer
	                if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
	                    //borramos la imagen
	                    archivoFotoAnterior.delete();
	                }
	            }

	            //Guardamos el nombre de la imagen/bvb
	            vehiculo.setImagen(nombreArchivo);
	            //Registramos en base de datos//
	            servicio.guardar(vehiculo);

	            response.put("producto", vehiculo);
	            response.put("mensaje","Imagen subida correctamente :"+nombreArchivo);

	        }


	        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	    }
		
		//2do METODO PARA SUBIR IMAGENES//
		@GetMapping("/Uploads/img/{nombreImagen:.+}")
		public ResponseEntity<Resource> verImagen(@PathVariable String nombreImagen){
		
			Path rutaArchivo = Paths.get("Uploads").resolve(nombreImagen).toAbsolutePath();
			
			Resource recurso = null;
			
			try {
				//codigo para acceder al archivo por url
				recurso = new UrlResource(rutaArchivo.toUri());
				
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
			
			if(!recurso.exists() && !recurso.isReadable()) {
				throw new RuntimeException("no se puede cargar a la imagen: "+nombreImagen);
			}
			
			HttpHeaders cabecera = new HttpHeaders();
			cabecera.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+recurso.getFilename()+"\"");
			
			
			
			return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
		}
		
		

}
