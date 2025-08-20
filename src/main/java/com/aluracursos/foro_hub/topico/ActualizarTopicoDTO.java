package com.aluracursos.foro_hub.topico;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarTopicoDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    // Getters y setters
}