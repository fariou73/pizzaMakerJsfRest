package com.simbirsoft.api.controllers;

import com.simbirsoft.modeles.Ingredient;
import com.simbirsoft.services.IngredientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/ingredients")
public class IngredientController {
    @Inject
    private IngredientService ingredientService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<Ingredient> getAll(){
        return ingredientService.getAll();
    }

    @Path("/post")
    @POST
    @Consumes("application/json")
    public Response createProductInJSON(Ingredient ingredient) throws Exception {
        ingredientService.updateIngredient(ingredient);
        return Response.status(201).build();
    }
}
