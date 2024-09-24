package dev.kof.Comercio.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdateProduto(
    String descricao,
    @PositiveOrZero int qtd,
    @Positive double precoCompra,
    @Positive double precoVenda,
    String codBarra,
    String ncm){
    
}
