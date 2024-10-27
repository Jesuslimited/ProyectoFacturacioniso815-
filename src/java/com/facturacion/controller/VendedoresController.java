package com.facturacion.controller;

import com.facturacion.entity.Vendedores;
import com.facturacion.facade.VendedoresFacade;
import com.facturacion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "vendedoresController")
@ViewScoped
public class VendedoresController extends AbstractController<Vendedores> {

    @Inject
    private MobilePageController mobilePageController;

    public VendedoresController() {
        // Inform the Abstract parent controller of the concrete Vendedores Entity
        super(Vendedores.class);
    }

}
