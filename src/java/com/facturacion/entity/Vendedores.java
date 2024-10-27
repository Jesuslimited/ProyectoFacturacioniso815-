/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesus
 */
@Entity
@Table(name = "VENDEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v")
    , @NamedQuery(name = "Vendedores.findByIdVendedor", query = "SELECT v FROM Vendedores v WHERE v.idVendedor = :idVendedor")
    , @NamedQuery(name = "Vendedores.findByNombre", query = "SELECT v FROM Vendedores v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vendedores.findByPorcientoComision", query = "SELECT v FROM Vendedores v WHERE v.porcientoComision = :porcientoComision")
    , @NamedQuery(name = "Vendedores.findByActivo", query = "SELECT v FROM Vendedores v WHERE v.activo = :activo")})
public class Vendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENDEDOR")
    private Integer idVendedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCIENTO_COMISION")
    private BigDecimal porcientoComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO")
    private Boolean activo;

    public Vendedores() {
    }

    public Vendedores(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedores(Integer idVendedor, String nombre, BigDecimal porcientoComision, Boolean activo) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.porcientoComision = porcientoComision;
        this.activo = activo;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPorcientoComision() {
        return porcientoComision;
    }

    public void setPorcientoComision(BigDecimal porcientoComision) {
        this.porcientoComision = porcientoComision;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.facturacion.entity.Vendedores[ idVendedor=" + idVendedor + " ]";
    }
    
}
