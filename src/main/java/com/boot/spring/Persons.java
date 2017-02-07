package com.boot.spring;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * Created by darlan on 30/01/17.
 */
@Path("/persons")
public interface Persons {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    void list(@Suspended AsyncResponse res);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    void post(@Suspended AsyncResponse res,
              final Person person);

}
