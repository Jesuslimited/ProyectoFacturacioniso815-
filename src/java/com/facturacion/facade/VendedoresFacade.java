/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facturacion.facade;

import com.facturacion.entity.Vendedores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jesus
 */
@Stateless
public class VendedoresFacade extends AbstractFacade<Vendedores> {

    @PersistenceContext(unitName = "ProyectoFacturacionISO815PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendedoresFacade() {
        super(Vendedores.class);
    }
    
}
