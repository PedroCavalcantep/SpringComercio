package dev.kof.Comercio.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUsuario(
        @NotNull @NotBlank String login,
        @NotNull @NotBlank String senha,
        @NotNull @NotBlank String cargo) {
}
