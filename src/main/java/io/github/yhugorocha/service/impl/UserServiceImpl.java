package io.github.yhugorocha.service.impl;

import io.github.yhugorocha.client.KeyCloakClient;
import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.dto.UserResponseDTO;
import io.github.yhugorocha.exception.BadRequestException;
import io.github.yhugorocha.exception.ForbiddenException;
import io.github.yhugorocha.exception.NotFoundException;
import io.github.yhugorocha.exception.UnauthorizedException;
import io.github.yhugorocha.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    @RestClient
    KeyCloakClient keyCloakClient;

    public List<UserResponseDTO> getUsersInKeyCloak(String token) {
        return keyCloakClient.getUsers(token);
    }

    public void createUserInKeyCloak(UserRepresentationDTO user, String token) {
        try{
            keyCloakClient.createUser(token, user);
        }catch (WebApplicationException e){
            Response response = e.getResponse();
            this.returnException(response.getStatus());
        }
    }

    @Override
    public void updateUserInKeyCloak(UserRepresentationDTO user, String id, String token) {
        try{
            keyCloakClient.updateUser(token, user, id);
        }catch (WebApplicationException e){
            Response response = e.getResponse();
            this.returnException(response.getStatus());
        }
    }

    @Override
    public void deleteUserInKeyCloak(String token, String id) {
        try{
            keyCloakClient.getUserById(token, id);
            keyCloakClient.deleteUser(token, id);
        }catch (WebApplicationException e){
            Response response = e.getResponse();
            this.returnException(response.getStatus());
        }
    }


    public void returnException(Integer statusCode){
        switch (statusCode){
            case 400: throw new BadRequestException("BadRequest");
            case 401: throw new UnauthorizedException("Unauthorized");
            case 403: throw new ForbiddenException("Forbidden");
            case 404: throw new NotFoundException("NotFound");
            case 405: throw new NotFoundException("MethodNotAllowed");
            case 500: throw new RuntimeException("ServerError");
        }
    }
}