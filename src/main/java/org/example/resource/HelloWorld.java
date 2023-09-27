package org.example.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class HelloWorld
{
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);
    @GET
    @Path("/world")
    public Response helloWorld(){
        return Response.ok("Hello World!").build();
    }
}
