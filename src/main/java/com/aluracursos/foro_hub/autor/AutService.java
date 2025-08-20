package com.aluracursos.foro_hub.autor;

import com.aluracursos.foro_hub.seguridad.JWTUtils;
import com.aluracursos.foro_hub.usuario.Usuario;
import com.aluracursos.foro_hub.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String login(AutRequest request) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword());

        authManager.authenticate(authToken);

        Usuario usuario = usuarioRepository.findByEmail(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return jwtUtils.generarToken(usuario);
    }
}