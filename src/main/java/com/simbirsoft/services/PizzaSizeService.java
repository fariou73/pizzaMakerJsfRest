package com.simbirsoft.services;

import com.simbirsoft.modeles.PizzaSize;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PizzaSizeService {
    private static final EntityManager ENTITY_MANAGER = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();


    public PizzaSize get(int id) {
        return ENTITY_MANAGER.find(PizzaSize.class, id);
    }

    public void removePizzaSize(int id) throws Exception {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.remove(get(id));
        ENTITY_MANAGER.getTransaction().commit();
    }

    public List<PizzaSize> getAll() {
        TypedQuery<PizzaSize> namedQuery = ENTITY_MANAGER.createNamedQuery("PizzaSize.getAll", PizzaSize.class);
        return namedQuery.getResultList();
    }

    public void updatePizzaSize(PizzaSize pizzaSize) throws Exception {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(pizzaSize);
        ENTITY_MANAGER.getTransaction().commit();
    }
}
