package com.aluracursos.foro_hub.auth;

import com.aluracursos.foro_hub.seguridad.JWTUtils;
import com.aluracursos.foro_hub.usuario.Usuario;
import com.aluracursos.foro_hub.usuario.UsuarioRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtService;
    private final UsuarioRepository userRepository;

    public AuthService(AuthenticationManager authenticationManager, JWTUtils jwtService, UsuarioRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Usuario user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.generarToken(user);
        return new AuthenticationResponse(token);
    }
}