package com.grupoasd.activosfijos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupoasd.activosfijos.exception.WrongDatesException;
import com.grupoasd.activosfijos.model.ActivoFijo;
import com.grupoasd.activosfijos.model.Entidad;
import com.grupoasd.activosfijos.repository.ActivosFijosCriteria;
import com.grupoasd.activosfijos.repository.ActivosFijosRepository;
import com.grupoasd.activosfijos.repository.EntidadRepository;

public class DefaultActivosService implements ActivosService {

	@Autowired
	ActivosFijosRepository activosRepository;

	@Autowired
	EntidadRepository entidadRepository;

	@Override
	public List<ActivoFijo> findAll() {
		return activosRepository.findAll();
	}

	@Override
	public List<ActivoFijo> findByCriteria(ActivosFijosCriteria criteria) {
		
		List<ActivoFijo> allRecords = activosRepository.findAll();
		
		return allRecords.stream()
		.filter(a -> a.getTipo().getId().equals(criteria.getTipo()))
		.filter(a -> a.getSerial().equals(criteria.getSerial()))
		.filter(a -> a.getFechaCompra().before(criteria.getFechaCompra()))
		.collect(Collectors.toList());
		
	}

	@Override
	public String createActivoFijo(ActivoFijo activo) {
		if(activo.getFechaBaja().before(activo.getFechaBaja())) {
	        throw new WrongDatesException("La fecha de Baja es inferior a la fecha de Compra");
		}
		activosRepository.save(activo);
		return activo.getSerial();
	}

	@Override
	public String modifyActivoFijo(ActivoFijo activo) {
		if(activo.getFechaBaja().before(activo.getFechaBaja())) {
	        throw new WrongDatesException("La fecha de Baja es inferior a la fecha de Compra");
		}
		activosRepository.save(activo);
		return activo.getSerial();
	}

	@Override
	public List<Entidad> findByTipo(Integer tipo) {
		List<Entidad> allRecords = entidadRepository.findAll();
		return allRecords.stream()
				.filter(e -> e.getTipo().getId().equals(tipo))
				.collect(Collectors.toList());
				
	}

}
