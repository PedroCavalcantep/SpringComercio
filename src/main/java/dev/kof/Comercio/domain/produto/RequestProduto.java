package dev.kof.Comercio.domain.produto;

import jakarta.validation.constraints.*;

public record RequestProduto(
        @NotNull String descricao,
        @NotNull @PositiveOrZero int qtd,
        @NotNull @Positive double precoCompra,
        @NotNull @Positive double precoVenda,
        @NotNull @NotBlank String codBarra,
        @NotNull @NotBlank String ncm) {
}

