package com.simbirsoft.modeles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Pizza.getAll", query = "from Pizza")
@Table(name = "Pizza")
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String size;

    private String ingredients;

    public Pizza() {

    }

    public Pizza(List<Ingredient> ingredientList, PizzaSize pizzaSize) {
        ingredients = convertToString(ingredientList);
        size = pizzaSize.getSize();
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String convertToString(List<Ingredient> ingredientList) {
        String result = "";
        String separatorCount = "%%%";
        String separatorLine = "}}";
        for (Ingredient ingredient : ingredientList) {
            result += ingredient.getName() + separatorCount + ingredient.getCount() + separatorLine;
        }
        return result;
    }

    private List<Ingredient> convertToIngedientList(String ingredients) {
        List<Ingredient> result = new ArrayList<>();
        String separatorCount = "%%%";
        String separatorLine = "}}";
        String arrayIngridients[] = ingredients.split(separatorLine);
        for (int i = 0; i < arrayIngridients.length; i++) {
            String nameAndCount[] = arrayIngridients[i].split(separatorCount);
            result.add(new Ingredient(nameAndCount[0], Integer.parseInt(nameAndCount[1])));
        }
        return result;
    }

    public PizzaSize getPizzaSize() {
        PizzaSize result = new PizzaSize();
        result.setSize(size);
        return result;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.size = pizzaSize.getSize();
    }

    public List<Ingredient> getIngredientList() {
        return convertToIngedientList(ingredients);
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredients = convertToString(ingredientList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngedientsInString(){
        String separator = "\r\n";
        String result = "";
        for (Ingredient ingredient : getIngredientList()){
            result+=ingredient.getName()+": " + ingredient.getCount() + separator;
        }
        return result;
    }

}
