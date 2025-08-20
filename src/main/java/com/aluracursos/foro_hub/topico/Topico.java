package com.aluracursos.foro_hub.topico;


import com.aluracursos.foro_hub.usuario.Usuario;
import com.aluracursos.foro_hub.curso.Curso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private EstadoTopico estado = EstadoTopico.NO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    // Getters y setters (o usa Lombok si prefieres)
}