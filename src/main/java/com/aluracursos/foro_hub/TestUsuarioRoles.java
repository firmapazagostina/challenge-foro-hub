package com.aluracursos.foro_hub;

import com.aluracursos.foro_hub.model.Role;
import com.aluracursos.foro_hub.model.RoleName;
import com.aluracursos.foro_hub.usuario.Usuario;

import java.util.Set;

public class TestUsuarioRoles {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setEmail("admin@example.com");
        usuario.setPassword("securepassword");

        Role adminRole = new Role(RoleName.ROLE_ADMIN);
        usuario.setRoles(Set.of(adminRole));

        boolean tieneRolAdmin = usuario.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        System.out.println("¿Tiene ROLE_ADMIN? " + tieneRolAdmin); // Debería imprimir true
    }
}