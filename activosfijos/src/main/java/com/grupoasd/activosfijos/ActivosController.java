package com.grupoasd.activosfijos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.activosfijos.exception.WrongDatesException;
import com.grupoasd.activosfijos.model.ActivoFijo;
import com.grupoasd.activosfijos.repository.ActivosFijosCriteria;
import com.grupoasd.activosfijos.services.ActivosService;

@RestController
@RequestMapping(value = "/activos")
public class ActivosController {
	
	@Autowired
	ActivosService activosService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivoFijo>> getAll() {
		
		List<ActivoFijo> responseList = activosService.findAll();
		
		if(responseList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(responseList, HttpStatus.NOT_FOUND);
			
	}
	
	@RequestMapping(value="/filteredby", method = RequestMethod.GET)
	public ResponseEntity<List<ActivoFijo>> getFilteredByCriteria(@PathVariable("criteria") ActivosFijosCriteria criteria) {
		List<ActivoFijo> responseList = activosService.findByCriteria(criteria);
		
		if(responseList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(responseList, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> createActivoFijo(@PathVariable("activo") ActivoFijo activo) {
		
		if(activo.getSerial().isEmpty() || null == activo.getEstadoActual().getId() || null == activo.getFechaCompra()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		StringBuilder sb = new StringBuilder();
		try {
			String serial = activosService.createActivoFijo(activo);
			sb.append(serial);
		}catch (WrongDatesException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(sb.toString(),HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> modifyActivoFijo(@PathVariable("activo") ActivoFijo activo) {
		if(activo.getSerial().isEmpty() || null == activo.getEstadoActual().getId() || null == activo.getFechaCompra()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		StringBuilder sb = new StringBuilder();
		try {
			String serial = activosService.modifyActivoFijo(activo);
			sb.append(serial);
		}catch (WrongDatesException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(sb.toString(),HttpStatus.OK);
	}

}
