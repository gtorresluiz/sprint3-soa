package com.fiap.checkpoint1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank String nome,
        @Email String email,
        @NotBlank String senha,
        String perfil, // Enum PerfilUsuario
        String rua,
        String cidade,
        String cep
) {}
