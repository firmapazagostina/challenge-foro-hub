package com.aluracursos.foro_hub.repository;


import com.aluracursos.foro_hub.model.Role;
import com.aluracursos.foro_hub.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
    boolean existsByName(RoleName name);
}