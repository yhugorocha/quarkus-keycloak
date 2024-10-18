package io.github.yhugorocha.service;

import io.github.yhugorocha.dto.UserRepresentationDTO;
import io.github.yhugorocha.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getUsersInKeyCloak(String token);
    void createUserInKeyCloak(UserRepresentationDTO user, String token);
    void updateUserInKeyCloak(UserRepresentationDTO user, String id, String token);
    void deleteUserInKeyCloak(String token, String id);

}
