package com.grupoasd.activosfijos.repository;

import java.util.Date;

public class ActivosFijosCriteria {

	private Integer tipo;
	private Date fechaCompra;
	private String serial;
	
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}

}
