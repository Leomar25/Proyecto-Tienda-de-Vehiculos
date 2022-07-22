package com.formacionspring.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title ="Api-Venta-Vehiculos",version="1.0",description ="Crud completo api restfull"))
public class ApirestVentaVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestVentaVehiculosApplication.class, args);
	}

}
