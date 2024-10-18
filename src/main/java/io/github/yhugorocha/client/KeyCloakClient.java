package io.github.yhugorocha.client;

import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.dto.UserResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Optional;

@RegisterRestClient
@ApplicationScoped
public interface KeyCloakClient {

    @GET
    @Path("/users")
    List<UserResponseDTO> getUsers(@HeaderParam("Authorization") String bearerToken);

    @GET
    @Path("/users/{user-id}")
    Optional<UserResponseDTO>getUserById(@HeaderParam("Authorization") String bearerToken, @PathParam("user-id") String id);

    @PUT
    @Path("/users/{user-id}")
    void updateUser(@HeaderParam("Authorization") String bearerToken, UserRepresentationDTO userRepresentationDTO, @PathParam("user-id") String id);

    @POST
    @Path("/users")
    void createUser(@HeaderParam("Authorization") String bearerToken, UserRepresentationDTO userRepresentationDTO);

    @DELETE
    @Path("/users/{user-id}")
    void deleteUser(@HeaderParam("Authorization") String bearerToken, @PathParam("user-id") String id);
}
