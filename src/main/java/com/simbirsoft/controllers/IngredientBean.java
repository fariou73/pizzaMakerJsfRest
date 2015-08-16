package com.simbirsoft.controllers;

import com.simbirsoft.modeles.Ingredient;
import com.simbirsoft.services.IngredientService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named(value = "ingredientBean")
@RequestScoped
public class IngredientBean implements Serializable {

    @Inject
    private IngredientService ingridientService;

    private String error = "";

    Logger log = Logger.getLogger(IngredientBean.class.getName());

    public IngredientBean() {
    }

    public String getError(){
        return error;
    }


    public List<Ingredient> getIngredientList() {
        try {
            return ingridientService.getAll();
        } catch (Exception e) {
            error = "Not complete operation with DB";
            return null;
        }

    }

    public void addIngredient(String name, int count) {
        try {
            if (name.length() > 0 && count >= 0) {
                boolean contains = false;
                for (Ingredient ingredient : ingridientService.getAll()) {
                    if (ingredient.getName() == name) {
                        contains = true;
                    }
                }
                if (!contains) {
                    Ingredient ingredient = new Ingredient(name, count);
                    ingridientService.updateIngredient(ingredient);
                }
            }
            error = "";
        } catch (Exception e) {
            error = "Not complete operation with DB";
        }

    }

    public void removeIngredient(int id) {
        try {
            ingridientService.removeIngredient(id);
            error = "";
        } catch (Exception e) {
            error = "Not complete operation with DB";
        }
    }

    public void updateIngredient(int id, String name, int count) {
        try {
            if (name.length() > 0 && count >= 0 && id >= 0) {
                Ingredient ingredient = ingridientService.get(id);
                ingredient.setName(name);
                ingredient.setCount(count);
                ingridientService.updateIngredient(ingredient);
            }
            error = "";
        } catch (Exception e) {
            error = "Not complete operation with DB";
        }

    }
}
