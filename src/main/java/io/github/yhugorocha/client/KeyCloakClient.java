package io.github.yhugorocha.client;

import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.dto.UserResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
@ApplicationScoped
public interface KeyCloakClient {

    @GET
    @Path("/users")
    List<UserResponseDTO> getUsers(@HeaderParam("Authorization") String bearerToken);

    @POST
    @Path("/users")
    void createUser(@HeaderParam("Authorization") String bearerToken, UserRepresentationDTO userRepresentationDTO);
}
