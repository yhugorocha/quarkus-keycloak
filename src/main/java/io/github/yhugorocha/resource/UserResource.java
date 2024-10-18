package io.github.yhugorocha.resource;

import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @Inject
    UserServiceImpl userServiceImpl;

    @GET
    public Response getUsers(@HeaderParam("Authorization") String authorization){
        return Response.ok(userServiceImpl.getUsersInKeyCloak(authorization)).build();
    }

    @POST
    @Path("/register")
    public Response createUser(@HeaderParam("Authorization") String authorization, UserRepresentationDTO user){
        userServiceImpl.createUserInKeyCloak(user, authorization);
        return Response.ok().build();
    }
}
