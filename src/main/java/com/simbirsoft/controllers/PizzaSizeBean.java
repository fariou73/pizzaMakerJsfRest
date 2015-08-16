package com.simbirsoft.controllers;

import com.simbirsoft.modeles.PizzaSize;
import com.simbirsoft.services.IngredientService;
import com.simbirsoft.services.PizzaService;
import com.simbirsoft.services.PizzaSizeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named(value = "pizzaSizeBean")
@RequestScoped
public class PizzaSizeBean implements Serializable {

    @Inject
    private PizzaSizeService pizzaSizeService;

    private String error = "";

    Logger log = Logger.getLogger(IngredientBean.class.getName());

    public PizzaSizeBean() {
    }

    public String getError(){
        return error;
    }


    public List<PizzaSize> getPizzaSize() {
        try {
            return pizzaSizeService.getAll();
        } catch (Exception e) {
            error = "Not complete operation with DB";
            return null;
        }

    }

    public void addPizzaSize(String size) {
        try {
            if (size.length() > 0) {
                boolean contains = false;
                for (PizzaSize pizzaSize : pizzaSizeService.getAll()) {
                    if (pizzaSize.getSize() == size) {
                        contains = true;
                    }
                }
                if (!contains) {
                    PizzaSize pizzaSize = new PizzaSize(size);
                    pizzaSizeService.updatePizzaSize(pizzaSize);
                }
            }
            error = "";
        } catch (Exception e) {
            error = "Not complete operation with DB";
        }

    }

    public void removePizzaSize(int id) {
        try {
            pizzaSizeService.removePizzaSize(id);
            error = "";
        } catch (Exception e) {
            error = "Not complete operation with DB";
        }
    }
}
