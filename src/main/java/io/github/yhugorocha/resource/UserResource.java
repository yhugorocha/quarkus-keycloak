package io.github.yhugorocha.resource;

import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.service.impl.UserServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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
    public Response createUser(@HeaderParam("Authorization") String authorization, UserRepresentationDTO user){
        userServiceImpl.createUserInKeyCloak(user, authorization);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}")
    public Response updateUser(@HeaderParam("Authorization") String authorization, UserRepresentationDTO user, @PathParam("id") String id){
        userServiceImpl.updateUserInKeyCloak(user, id, authorization);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@HeaderParam("Authorization") String authorization, @PathParam("id") String id){
        userServiceImpl.deleteUserInKeyCloak(authorization, id);
        return Response.noContent().build();
    }


}
