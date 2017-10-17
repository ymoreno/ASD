/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoasd.activosfijos.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yesid
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    , @NamedQuery(name = "Asignacion.findBySerial", query = "SELECT a FROM Asignacion a WHERE a.asignacionPK.serial = :serial")
    , @NamedQuery(name = "Asignacion.findById", query = "SELECT a FROM Asignacion a WHERE a.asignacionPK.id = :id")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionPK asignacionPK;

    public Asignacion() {
    }

    public Asignacion(AsignacionPK asignacionPK) {
        this.asignacionPK = asignacionPK;
    }

    public Asignacion(String serial, String id) {
        this.asignacionPK = new AsignacionPK(serial, id);
    }

    public AsignacionPK getAsignacionPK() {
        return asignacionPK;
    }

    public void setAsignacionPK(AsignacionPK asignacionPK) {
        this.asignacionPK = asignacionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionPK != null ? asignacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        return ((this.asignacionPK == null && other.asignacionPK != null) || (this.asignacionPK != null && !this.asignacionPK.equals(other.asignacionPK))) ? true : false;
    }

    @Override
    public String toString() {
        return "com.broterhood.treasures.entidades.temporal.Asignacion[ asignacionPK=" + asignacionPK + " ]";
    }
    
}
