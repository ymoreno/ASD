/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoasd.activosfijos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yesid
 */
@Embeddable
public class AsignacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "id")
    private String id;

    public AsignacionPK() {
    }

    public AsignacionPK(String serial, String id) {
        this.serial = serial;
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serial != null ? serial.hashCode() : 0);
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionPK)) {
            return false;
        }
        AsignacionPK other = (AsignacionPK) object;
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.broterhood.treasures.entidades.temporal.AsignacionPK[ serial=" + serial + ", id=" + id + " ]";
    }
    
}
