package com.aluracursos.foro_hub.auth;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String email;
    private String password;

    // Getters y setters
}