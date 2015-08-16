package com.simbirsoft.services;

import com.simbirsoft.modeles.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class IngredientService {
    private static final EntityManager ENTITY_MANAGER = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Ingredient get(int id) {
        return ENTITY_MANAGER.find(Ingredient.class, id);
    }

    public void removeIngredient(int id) throws Exception {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.remove(get(id));
        ENTITY_MANAGER.getTransaction().commit();
    }

    public List<Ingredient> getAll() {
        TypedQuery<Ingredient> namedQuery = ENTITY_MANAGER.createNamedQuery("Ingredient.getAll", Ingredient.class);
        return namedQuery.getResultList();
    }

    public void updateIngredient(Ingredient ingredient) throws Exception {
        ENTITY_MANAGER.getTransaction().begin();
        ENTITY_MANAGER.merge(ingredient);
        ENTITY_MANAGER.getTransaction().commit();
    }
}
