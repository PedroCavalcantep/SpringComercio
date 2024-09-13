package dev.kof.Comercio.domain.produto;


import jakarta.validation.constraints.NotNull;


public record RequestProduto(String descricao, double precoCompra, double precoVenda, String codBarra, String ncm) {
    
}
