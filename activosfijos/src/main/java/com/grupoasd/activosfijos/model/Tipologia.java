/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoasd.activosfijos.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yesid
 */
@Entity
@Table(name = "tipologia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipologia.findAll", query = "SELECT t FROM Tipologia t")
    , @NamedQuery(name = "Tipologia.findById", query = "SELECT t FROM Tipologia t WHERE t.id = :id")
    , @NamedQuery(name = "Tipologia.findByNombre", query = "SELECT t FROM Tipologia t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tipologia.findByPadre", query = "SELECT t FROM Tipologia t WHERE t.padre = :padre")})
public class Tipologia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "padre")
    private Short padre;
    @OneToMany(mappedBy = "estadoActual")
    private Collection<ActivoFijo> activoFijoCollection;
    @OneToMany(mappedBy = "tipo")
    private Collection<ActivoFijo> activoFijoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<Entidad> entidadCollection;

    public Tipologia() {
    }

    public Tipologia(Integer id) {
        this.id = id;
    }

    public Tipologia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getPadre() {
        return padre;
    }

    public void setPadre(Short padre) {
        this.padre = padre;
    }

    @XmlTransient
    public Collection<ActivoFijo> getActivoFijoCollection() {
        return activoFijoCollection;
    }

    public void setActivoFijoCollection(Collection<ActivoFijo> activoFijoCollection) {
        this.activoFijoCollection = activoFijoCollection;
    }

    @XmlTransient
    public Collection<ActivoFijo> getActivoFijoCollection1() {
        return activoFijoCollection1;
    }

    public void setActivoFijoCollection1(Collection<ActivoFijo> activoFijoCollection1) {
        this.activoFijoCollection1 = activoFijoCollection1;
    }

    @XmlTransient
    public Collection<Entidad> getEntidadCollection() {
        return entidadCollection;
    }

    public void setEntidadCollection(Collection<Entidad> entidadCollection) {
        this.entidadCollection = entidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipologia)) {
            return false;
        }
        Tipologia other = (Tipologia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupoasd.activosfijos.model.Tipologia[ id=" + id + " ]";
    }
    
}
