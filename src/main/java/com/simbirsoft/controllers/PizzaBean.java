package com.simbirsoft.controllers;

import com.simbirsoft.modeles.Pizza;
import com.simbirsoft.services.PizzaService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named(value = "pizzaBean")
@RequestScoped
public class PizzaBean implements Serializable {
    @Inject
    private PizzaService pizzaService;

    private String error = "";

    Logger log = Logger.getLogger(PizzaBean.class.getName());

    public PizzaBean() {
    }

    public String getError() {
        return error;
    }


    public List<Pizza> getPizzaList() {
        try {
            return pizzaService.getAll();
        } catch (Exception e) {
            error = "Not complete operation with DB";
            return null;
        }
    }

    public void removePizza(int id) {
        try {
            pizzaService.removePizza(id);
            error = "";
        } catch (Exception e) {
            error = "Not complete operation with DB";
        }
    }
}
