package com.formacionspring.apirest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalles_ventas")
public class Detalles_ventas implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private int cantidad;
	
	@Column(nullable = false)
	private double precioventa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ventas")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Venta venta;
	
	//METODOS SETTHERS AND GETTHERS//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioventa() {
		return precioventa;
	}

	public void setPreciocompra(double precioventa) {
		this.precioventa = precioventa;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
