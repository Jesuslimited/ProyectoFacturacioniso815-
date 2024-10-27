package com.facturacion.controller;

import com.facturacion.entity.Articulos;
import com.facturacion.facade.ArticulosFacade;
import com.facturacion.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "articulosController")
@ViewScoped
public class ArticulosController extends AbstractController<Articulos> {

    @Inject
    private MobilePageController mobilePageController;

    public ArticulosController() {
        // Inform the Abstract parent controller of the concrete Articulos Entity
        super(Articulos.class);
    }

}
