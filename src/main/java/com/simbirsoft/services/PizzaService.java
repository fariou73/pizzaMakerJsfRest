package com.simbirsoft.services;

import com.simbirsoft.modeles.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PizzaService {
    private static final EntityManager ENTITY_MANAGER = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();


    public Pizza get(int id) {
        return ENTITY_MANAGER.find(Pizza.class, id);
    }

    public void removePizza(int id) throws Exception {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.remove(get(id));
        ENTITY_MANAGER.getTransaction().commit();
    }

    public List<Pizza> getAll() {
        TypedQuery<Pizza> namedQuery = ENTITY_MANAGER.createNamedQuery("Pizza.getAll", Pizza.class);
        return namedQuery.getResultList();
    }

    public void updatePizza(Pizza pizza) throws Exception {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(pizza);
        ENTITY_MANAGER.getTransaction().commit();
    }
}
