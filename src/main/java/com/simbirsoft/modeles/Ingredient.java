package com.simbirsoft.modeles;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Ingredient.getAll", query = "from Ingredient")
@Table(name = "Ingredient")
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int count;

    public Ingredient() {
    }

    public Ingredient(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

