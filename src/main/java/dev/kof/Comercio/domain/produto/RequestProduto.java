package dev.kof.Comercio.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduto(
        @NotNull @NotBlank String descricao,
        @NotNull double precoCompra,
        @NotNull double precoVenda,
        @NotNull @NotBlank String codBarra,
        @NotNull @NotBlank String ncm) {
}

