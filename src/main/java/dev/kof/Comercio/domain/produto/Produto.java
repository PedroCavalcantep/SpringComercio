package dev.kof.Comercio.domain.produto;

import jakarta.persistence.*;
import lombok.*;

@Table(name="produto")
@Entity(name="produto")
@EqualsAndHashCode(of="codProd")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProd;

    private String descricao;

    private int qtd;

    private double precoCompra;

    private double precoVenda;

    private String codBarra;

    private String ncm;

    public Produto(RequestProduto requestProduto) {
        this.descricao = requestProduto.descricao();
        this.qtd = requestProduto.qtd();
        this.precoCompra = requestProduto.precoCompra();
        this.precoVenda = requestProduto.precoVenda();
        this.codBarra = requestProduto.codBarra();
        this.ncm = requestProduto.ncm();
    }
    
}

