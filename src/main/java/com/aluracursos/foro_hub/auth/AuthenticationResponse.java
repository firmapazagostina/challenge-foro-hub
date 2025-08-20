package com.aluracursos.foro_hub.auth;


import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    // Getter
}