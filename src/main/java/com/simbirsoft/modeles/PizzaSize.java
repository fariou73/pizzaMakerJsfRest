package com.simbirsoft.modeles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "PizzaSize.getAll", query = "from PizzaSize")
@Table(name = "PizzaSize")
public class PizzaSize implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String size;

    public PizzaSize() {
    }

    public PizzaSize(String size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}

