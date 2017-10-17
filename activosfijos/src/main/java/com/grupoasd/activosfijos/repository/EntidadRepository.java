package com.grupoasd.activosfijos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoasd.activosfijos.model.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, String> {

}
