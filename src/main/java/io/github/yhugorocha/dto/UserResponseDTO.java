package io.github.yhugorocha.dto;

public record UserResponseDTO(String id,
                              String username,
                              String firstName,
                              String lastName,
                              String email,
                              Boolean emailVerified,
                              Boolean enabled,
                              AttributesResponseDTO attributes) {
}
