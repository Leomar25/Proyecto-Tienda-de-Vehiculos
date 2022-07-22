package com.formacionspring.apirest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "pagos")
public class Pago implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private double monto;
	
	@Column(nullable = false)
	private String tipodepago;
	
	//METODOS SETTHERS AND GETTHERS//
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	public String getTipodepago() {
		return tipodepago;
	}

	public void setTipodepago(String tipodepago) {
		this.tipodepago = tipodepago;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
