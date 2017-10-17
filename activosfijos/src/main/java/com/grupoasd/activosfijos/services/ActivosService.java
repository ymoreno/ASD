package com.grupoasd.activosfijos.services;

import java.util.List;

import com.grupoasd.activosfijos.model.ActivoFijo;
import com.grupoasd.activosfijos.model.Entidad;
import com.grupoasd.activosfijos.repository.ActivosFijosCriteria;

public interface ActivosService {

	List<ActivoFijo> findAll();
	
	List<ActivoFijo> findByCriteria(ActivosFijosCriteria criteria);
	
	String createActivoFijo(ActivoFijo activo);

	String modifyActivoFijo(ActivoFijo activo);
	
	List<Entidad> findByTipo(Integer tipo);

}
