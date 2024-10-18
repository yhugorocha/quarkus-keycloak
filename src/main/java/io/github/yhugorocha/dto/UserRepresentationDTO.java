package io.github.yhugorocha.dto;

import java.util.List;

public record UserRepresentationDTO(String username,
                                    String firstName,
                                    String lastName,
                                    String email,
                                    Boolean emailVerified,
                                    Boolean enabled,
                                    AttributesDTO attributes,
                                    List<String> groups,
                                    List<String> realmRoles,
                                    List<credentialsDTO> credentials) {
}
