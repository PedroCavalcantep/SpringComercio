package dev.kof.Comercio.domain.produto;

public record UpdateProduto(
    String descricao,
    double precoCompra,
    double precoVenda,
    String codBarra,
    String ncm){
    
}
