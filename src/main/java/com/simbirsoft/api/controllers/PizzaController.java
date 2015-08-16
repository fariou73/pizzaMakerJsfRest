package com.simbirsoft.api.controllers;


import com.simbirsoft.modeles.Pizza;
import com.simbirsoft.services.PizzaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pizzas")
public class PizzaController {
    @Inject
    private PizzaService pizzaService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<Pizza> getAll(){
        return pizzaService.getAll();
    }

    @Path("/post")
    @POST
    @Consumes("application/json")
    public Response createProductInJSON(Pizza pizza) throws Exception {
        pizzaService.updatePizza(pizza);
        return Response.status(201).build();
    }
}
