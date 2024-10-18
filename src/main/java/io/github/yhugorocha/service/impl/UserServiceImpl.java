package io.github.yhugorocha.service.impl;

import io.github.yhugorocha.client.KeyCloakClient;
import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.dto.UserResponseDTO;
import io.github.yhugorocha.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
        keyCloakClient.createUser(token, user);
    }
}