package dev.kof.Comercio.domain.produto;

import dev.kof.Comercio.GlobalHandlingException.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByDescricao(String descricao);
}
