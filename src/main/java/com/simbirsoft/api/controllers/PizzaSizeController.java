package com.simbirsoft.api.controllers;

import com.simbirsoft.modeles.PizzaSize;
import com.simbirsoft.services.PizzaSizeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sizes")
public class PizzaSizeController {
    @Inject
    private PizzaSizeService pizzaSizeService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<PizzaSize> getAll(){
        return pizzaSizeService.getAll();
    }

    @Path("/post")
    @POST
    @Consumes("application/json")
    public Response createProductInJSON(PizzaSize pizzaSize) throws Exception {
        pizzaSizeService.updatePizzaSize(pizzaSize);
        return Response.status(201).build();
    }
}