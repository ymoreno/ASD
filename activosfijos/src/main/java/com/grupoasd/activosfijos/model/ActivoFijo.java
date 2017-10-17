/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoasd.activosfijos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yesid
 */
@Entity
@Table(name = "activo_fijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoFijo.findAll", query = "SELECT a FROM ActivoFijo a")
    , @NamedQuery(name = "ActivoFijo.findBySerial", query = "SELECT a FROM ActivoFijo a WHERE a.serial = :serial")
    , @NamedQuery(name = "ActivoFijo.findByAlto", query = "SELECT a FROM ActivoFijo a WHERE a.alto = :alto")
    , @NamedQuery(name = "ActivoFijo.findByAncho", query = "SELECT a FROM ActivoFijo a WHERE a.ancho = :ancho")
    , @NamedQuery(name = "ActivoFijo.findByColor", query = "SELECT a FROM ActivoFijo a WHERE a.color = :color")
    , @NamedQuery(name = "ActivoFijo.findByFechaBaja", query = "SELECT a FROM ActivoFijo a WHERE a.fechaBaja = :fechaBaja")
    , @NamedQuery(name = "ActivoFijo.findByFechaCompra", query = "SELECT a FROM ActivoFijo a WHERE a.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "ActivoFijo.findByLargo", query = "SELECT a FROM ActivoFijo a WHERE a.largo = :largo")
    , @NamedQuery(name = "ActivoFijo.findByNombre", query = "SELECT a FROM ActivoFijo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "ActivoFijo.findByNumeroInterno", query = "SELECT a FROM ActivoFijo a WHERE a.numeroInterno = :numeroInterno")
    , @NamedQuery(name = "ActivoFijo.findByPeso", query = "SELECT a FROM ActivoFijo a WHERE a.peso = :peso")
    , @NamedQuery(name = "ActivoFijo.findByValorCompra", query = "SELECT a FROM ActivoFijo a WHERE a.valorCompra = :valorCompra")})
public class ActivoFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "serial")
    private String serial;
    @Column(name = "alto")
    private Integer alto;
    @Column(name = "ancho")
    private Integer ancho;
    @Size(max = 10)
    @Column(name = "color")
    private String color;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "largo")
    private Integer largo;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 25)
    @Column(name = "numero_interno")
    private String numeroInterno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "valor_compra")
    private BigDecimal valorCompra;
    @JoinTable(name = "asignacion", joinColumns = {
        @JoinColumn(name = "serial", referencedColumnName = "serial")}, inverseJoinColumns = {
        @JoinColumn(name = "id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Entidad> entidadCollection;
    @JoinColumn(name = "estado_actual", referencedColumnName = "id")
    @ManyToOne
    private Tipologia estadoActual;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne
    private Tipologia tipo;

    public ActivoFijo() {
    }

    public ActivoFijo(String serial) {
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroInterno() {
        return numeroInterno;
    }

    public void setNumeroInterno(String numeroInterno) {
        this.numeroInterno = numeroInterno;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    @XmlTransient
    public Collection<Entidad> getEntidadCollection() {
        return entidadCollection;
    }

    public void setEntidadCollection(Collection<Entidad> entidadCollection) {
        this.entidadCollection = entidadCollection;
    }

    public Tipologia getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Tipologia estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Tipologia getTipo() {
        return tipo;
    }

    public void setTipo(Tipologia tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ActivoFijo)) {
            return false;
        }
        ActivoFijo other = (ActivoFijo) object;
        return (this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial)) ? true : false;
    }

    @Override
    public String toString() {
        return "com.grupoasd.activosfijos.model.ActivoFijo[ serial=" + serial + " ]";
    }
    
}
